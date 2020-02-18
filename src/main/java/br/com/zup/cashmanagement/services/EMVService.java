package br.com.zup.cashmanagement.services;

import br.com.zup.cashmanagement.models.QrCode;

public abstract class EMVService {

    // public static String gerarHashEMV(QrCode qrCode){
    //     switch (qrCode.getTipo()) {
    //         case value:
                
    //             break;
        
    //         default:
    //             break;
    //     }
    // }

    public static String gerarHashEMVDinamico(QrCode qrCode){
        StringBuilder builder = new StringBuilder();

        builder.append(criarAtributo("00", "02", 01))
            .append(criarAtributo("01", "02", 12))
            .append(criarAtributo("26", "74")) //Para iniciar os dados de conta
            .append(criarAtributo("00", "14", "br.gov.bcb.spi")) //Nao sei o que siginifica esse dominio
            .append(criarAtributo("21", "08", qrCode.getBanco()))
            .append(criarAtributo("22", "04", qrCode.getTipoConta()))
            .append(criarAtributo("23", "08", qrCode.getAgencia()))
            .append(criarAtributo("24", "20", qrCode.getConta()))//FInaliza dados da conta
            .append(criarAtributo("52", "04", 0000)) //Parece que o bacen nao tem esses dados ainda ou é confimação do fim dos dados bancarios
            .append(criarAtributo("53", "03", 986)) //Nao sei que valor é este
            .append(criarAtributo("54", "06", qrCode.getValor()))//Aqui é o valor do qrcode, uma duvida, parece que o limite do valor é 6 digitos, eu conto o '.' como digito
            .append(criarAtributo("58", "02", "BR"))//Pais, tem que trazer esses dados do qrcode ou pego do local do cliente
            .append(criarAtributo("59", "13", "FULANO DE TAL"))
            .append(criarAtributo("60", "08", "BRASILIA")) //Cidade, mesma duvida de cima
            .append(criarAtributo("62", "19"))
            .append(criarAtributo("05", "15", "RP12345678-2019"))//Nao sei que valor é este
            .append(criarAtributo("80", "72"))
            .append(criarAtributo("00", "14", "br.gov.bcb.spi"))//Nao sei que valor é este
            .append(criarAtributo("25", "50", "http://localhost:8080/qrcode/dinamico/" + qrCode.getId()))
            .append(criarAtributo("63", "04", "34D1"));

        return builder.toString();
    }

    private static String criarAtributo(Object id, Object tam, Object valor){
        StringBuilder builder = new StringBuilder();
        builder.append(id).append(tam).append(valor);
        return builder.toString();
    }

    private static String criarAtributo(Object id, Object tam){
        StringBuilder builder = new StringBuilder();
        builder.append(id).append(tam);
        return builder.toString();
    }

}