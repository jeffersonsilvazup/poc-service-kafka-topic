package br.com.zup.cashmanagement.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QrCodeEstatico {

    @NotNull
    @NotEmpty
    private String alias;

    @NotEmpty
    private BigDecimal valor;

}