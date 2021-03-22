package com.jonathanfiss.ApiRestSpringBoot.controller;

import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteDTO;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteRequestDTO;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteResponseDTO;
import com.jonathanfiss.ApiRestSpringBoot.repository.ClienteRepository;
import com.jonathanfiss.ApiRestSpringBoot.service.CadastroClienteService;
import com.jonathanfiss.ApiRestSpringBoot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> busca(@PathVariable Long clienteId) {
        Optional<ClienteResponseDTO> cliente = clienteRepository.findById(clienteId);
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO adicionar(@RequestBody @Valid ClienteRequestDTO clienteDTO) {
        return clienteService.salvar(clienteDTO);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long clienteId, @RequestBody ClienteDTO clienteDTO) {

        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        clienteDTO.setId(clienteId);
        clienteDTO = clienteService.salvar(clienteDTO);

        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deletar(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        clienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();
    }
}
