package br.com.zup.cashmanagement.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.cashmanagement.enums.TipoConta;
import br.com.zup.cashmanagement.enums.TipoQrCode;
import br.com.zup.cashmanagement.models.QrCode;
import br.com.zup.cashmanagement.services.EMVService;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QrCodeDinamicoDTO {

    private String id;
    
    private TipoQrCode tipo;

    private BigDecimal valor;

    private Long banco;

    private Long agencia;

    private Long conta;
    
    private String url;
    
    private String indentificador;
    
    private BigDecimal juros;
    
    private BigDecimal multa;
    
    private BigDecimal desconto;
    
    private BigDecimal abatimento;
    
    private LocalDate vencimento;

    private TipoConta tipoConta;

    private String hash;

    public QrCodeDinamicoDTO(QrCode qrCode){
        this.setTipo(qrCode.getTipo());
        this.setValor(qrCode.getValor());
        this.setBanco(qrCode.getBanco());
        this.setAgencia(qrCode.getAgencia());
        this.setConta(qrCode.getConta());
        this.setUrl(qrCode.getUrl());
        this.setIndentificador(qrCode.getIdentificador());
        this.setJuros(qrCode.getJuros());
        this.setMulta(qrCode.getMulta());
        this.setDesconto(qrCode.getDesconto());
        this.setAbatimento(qrCode.getAbatimento());
        this.setVencimento(qrCode.getVencimento());
        this.setTipoConta(qrCode.getTipoConta());
        this.setId(qrCode.getId());
        this.setHash(EMVService.gerarHashEMVDinamico(qrCode));
    }
}