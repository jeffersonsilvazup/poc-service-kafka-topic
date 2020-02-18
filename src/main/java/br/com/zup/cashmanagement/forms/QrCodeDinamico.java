package br.com.zup.cashmanagement.forms;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.cashmanagement.enums.TipoConta;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QrCodeDinamico {

    @NotEmpty
    private BigDecimal valor;

    @NotEmpty
    private Long banco;

    @NotEmpty
    private Long agencia;

    @NotEmpty
    private Long conta;
    
    @NotEmpty
    @NotNull
    private String url;
    
    @NotEmpty
    @NotNull
    private String indentificador;
    
    @NotEmpty
    private BigDecimal juros;
    
    @NotEmpty
    private BigDecimal multa;
    
    @NotEmpty
    private BigDecimal desconto;
    
    @NotEmpty
    private BigDecimal abatimento;
    
    @NotEmpty
    private LocalDate vencimento;

    @NotEmpty
    private TipoConta tipoConta;

    
}