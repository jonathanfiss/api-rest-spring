package com.jonathanfiss.ApiRestSpringBoot.api.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrdemServicoInput {

    private String descricao;
    private BigDecimal preco;
    private ClienteIdInput cliente;
}
