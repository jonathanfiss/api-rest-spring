package com.jonathanfiss.ApiRestSpringBoot.controller;

import com.jonathanfiss.ApiRestSpringBoot.dto.OrdemServicoRequestDTO;
import com.jonathanfiss.ApiRestSpringBoot.dto.OrdemServicoResponseDTO;
import com.jonathanfiss.ApiRestSpringBoot.domain.model.OrdemServico;
import com.jonathanfiss.ApiRestSpringBoot.repository.OrdemServiceRepository;
import com.jonathanfiss.ApiRestSpringBoot.service.GestaoOrdemServicoService;
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
    public OrdemServicoResponseDTO criar(@RequestBody @Valid OrdemServicoRequestDTO ordemServicoRequestDTO){
        return toModel(gestaoOrdemServicoService.criar(toEntity(ordemServicoRequestDTO)));
    }

    @GetMapping
    public List<OrdemServicoResponseDTO> listar(){
        return toCollectionModel(ordemServiceRepository.findAll());
    }

    @GetMapping("/{orderServicoId}")
    public ResponseEntity<OrdemServicoResponseDTO> buscar(@PathVariable Long orderServicoId) {
        Optional<OrdemServico> ordemServico = ordemServiceRepository.findById(orderServicoId);
        if (ordemServico.isPresent()){
            return ResponseEntity.ok(toModel(ordemServico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    private OrdemServicoResponseDTO toModel(OrdemServico ordemServico) {
        return modelMapper.map(ordemServico, OrdemServicoResponseDTO.class);
    }

    private List<OrdemServicoResponseDTO> toCollectionModel(List<OrdemServico> ordensServicos){
        return ordensServicos.stream()
                .map(ordemServico -> toModel(ordemServico))
                .collect(Collectors.toList());
    }

    private OrdemServico toEntity(OrdemServicoRequestDTO ordemServicoRequestDTO) {
        return modelMapper.map(ordemServicoRequestDTO, OrdemServico.class);
    }
}
