package com.jonathanfiss.ApiRestSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.StatusOrdemServico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoResponseDTO {

    private Long id;
    private ClienteResponseDTO cliente;
    private String descricao;
    private BigDecimal preco;
    private StatusOrdemServico status;
    private OffsetDateTime dataAbertura;
    private OffsetDateTime dataFinalizacao;

}
