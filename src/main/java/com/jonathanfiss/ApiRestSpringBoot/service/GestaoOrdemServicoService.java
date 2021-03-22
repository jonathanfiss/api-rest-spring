package com.jonathanfiss.ApiRestSpringBoot.service;

import com.jonathanfiss.ApiRestSpringBoot.domain.exception.NegocioException;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteDTO;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.Comentario;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.OrdemServico;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.StatusOrdemServico;
import com.jonathanfiss.ApiRestSpringBoot.repository.ClienteRepository;
import com.jonathanfiss.ApiRestSpringBoot.repository.ComentarioRepository;
import com.jonathanfiss.ApiRestSpringBoot.repository.OrdemServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServiceRepository ordemServiceRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico criar(OrdemServico ordemServico){
        ClienteDTO clienteDTO = clienteRepository.findById(ordemServico.getClienteDTO().getId()).orElseThrow(() -> new NegocioException("Cliente não encontrado."));

        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(OffsetDateTime.now());
        ordemServico.setClienteDTO(clienteDTO);

        return ordemServiceRepository.save(ordemServico);
    }

    public Comentario adicionarComentario(Long ordemServicoId, String descricao){
        OrdemServico ordemServico = ordemServiceRepository.findById(ordemServicoId)
                .orElseThrow(() -> new NegocioException("Ordem de servoço não encontrada"));

        Comentario comentario = new Comentario();
        comentario.setDataEmvio(OffsetDateTime.now());
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);

        return comentarioRepository.save(comentario);
    }
}
