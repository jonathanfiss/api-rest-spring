package com.jonathanfiss.ApiRestSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoRequestDTO {
    @NotBlank(message = "Descricao is mandatory")
    private String descricao;
    @NotBlank(message = "Preco is mandatory")
    private BigDecimal preco;
    private ClienteRequestDTO cliente;
}
