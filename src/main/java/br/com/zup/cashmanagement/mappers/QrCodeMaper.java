package br.com.zup.cashmanagement.mappers;

import br.com.zup.cashmanagement.enums.TipoQrCode;
import br.com.zup.cashmanagement.forms.QrCodeDinamico;
import br.com.zup.cashmanagement.forms.QrCodeEstatico;
import br.com.zup.cashmanagement.models.QrCode;

public abstract class QrCodeMaper {

    public static QrCode qrCodeEstaticoToQrCode(QrCodeEstatico qrCodeEstatico){
        QrCode qrCode = new QrCode();

        qrCode.setValor(qrCodeEstatico.getValor());
        qrCode.setTipo(TipoQrCode.ESTATICO);
        qrCode.setAlias(qrCodeEstatico.getAlias());

        return qrCode;
    }

    public static QrCode qrCodeDinamicoToQrCode(QrCodeDinamico qrCodeDinamico){
        QrCode qrCode = new QrCode();

        qrCode.setTipo(TipoQrCode.DINAMICO);

        qrCode.setValor(qrCodeDinamico.getValor());
        qrCode.setBanco(qrCodeDinamico.getBanco());
        qrCode.setAgencia(qrCodeDinamico.getAgencia());
        qrCode.setConta(qrCodeDinamico.getConta());
        qrCode.setUrl(qrCodeDinamico.getUrl());
        qrCode.setIndentificador(qrCodeDinamico.getIndentificador());
        qrCode.setJuros(qrCodeDinamico.getJuros());
        qrCode.setMulta(qrCodeDinamico.getMulta());
        qrCode.setDesconto(qrCodeDinamico.getDesconto());
        qrCode.setAbatimento(qrCodeDinamico.getAbatimento());
        qrCode.setVencimento(qrCodeDinamico.getVencimento());
        qrCode.setTipoConta(qrCodeDinamico.getTipoConta());

        return qrCode;
    }
    
}