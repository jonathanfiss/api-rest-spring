package com.jonathanfiss.ApiRestSpringBoot.api.controller;

import com.jonathanfiss.ApiRestSpringBoot.api.model.request.OrdemServicoInput;
import com.jonathanfiss.ApiRestSpringBoot.api.model.response.OrdemServicoOutput;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.OrdemServico;
import com.jonathanfiss.ApiRestSpringBoot.domain.repository.OrdemServiceRepository;
import com.jonathanfiss.ApiRestSpringBoot.domain.service.GestaoOrdemServicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServicoService;

    @Autowired
    private OrdemServiceRepository ordemServiceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoOutput criar(@RequestBody @Valid OrdemServicoInput ordemServicoInput){
        return toModel(gestaoOrdemServicoService.criar(toEntity(ordemServicoInput)));
    }

    @GetMapping
    public List<OrdemServicoOutput> listar(){
        return toCollectionModel(ordemServiceRepository.findAll());
    }

    @GetMapping("/{orderServicoId}")
    public ResponseEntity<OrdemServicoOutput> buscar(@PathVariable Long orderServicoId) {
        Optional<OrdemServico> ordemServico = ordemServiceRepository.findById(orderServicoId);
        if (ordemServico.isPresent()){
            return ResponseEntity.ok(toModel(ordemServico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    private OrdemServicoOutput toModel(OrdemServico ordemServico) {
        return modelMapper.map(ordemServico, OrdemServicoOutput.class);
    }

    private List<OrdemServicoOutput> toCollectionModel(List<OrdemServico> ordensServicos){
        return ordensServicos.stream()
                .map(ordemServico -> toModel(ordemServico))
                .collect(Collectors.toList());
    }

    private OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {
        return modelMapper.map(ordemServicoInput, OrdemServico.class);
    }
}
