package com.jonathanfiss.ApiRestSpringBoot.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @NotNull
    @ManyToOne
    private ClienteDTO clienteDTO;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusOrdemServico status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataAbertura;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

    @OneToMany(mappedBy = "ordemServico")
    private List<Comentario> comentarios = new ArrayList<>();


}
