package com.jonathanfiss.ApiRestSpringBoot.domain.model;

import com.jonathanfiss.ApiRestSpringBoot.domain.model.OrdemServico;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    private OrdemServico ordemServico;
    private OffsetDateTime dataEmvio;
}
