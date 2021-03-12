package com.jonathanfiss.ApiRestSpringBoot.domain.service;

import com.jonathanfiss.ApiRestSpringBoot.domain.exception.NegocioException;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.Cliente;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.OrdemServico;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.StatusOrdemServico;
import com.jonathanfiss.ApiRestSpringBoot.domain.repository.ClienteRepository;
import com.jonathanfiss.ApiRestSpringBoot.domain.repository.OrdemServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServiceRepository ordemServiceRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico criar(OrdemServico ordemServico){
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId()).orElseThrow(() -> new NegocioException("Cliente não encontrado."));

        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(OffsetDateTime.now());
        ordemServico.setCliente(cliente);

        return ordemServiceRepository.save(ordemServico);
    }
}
