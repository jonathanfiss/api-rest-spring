package com.jonathanfiss.ApiRestSpringBoot.api.model.response;

import com.jonathanfiss.ApiRestSpringBoot.domain.model.StatusOrdemServico;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class OrdemServicoOutput {

    private Long id;
    private ClienteResumoOutput cliente;
    private String descricao;
    private BigDecimal preco;
    private StatusOrdemServico status;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalizacao;

}
