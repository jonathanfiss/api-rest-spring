package com.jonathanfiss.ApiRestSpringBoot.service;

import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteDTO;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteRequestDTO;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteResponseDTO;
import com.jonathanfiss.ApiRestSpringBoot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ClienteResponseDTO salvar(ClienteRequestDTO clienteDTO) {
        ClienteResponseDTO clienteDTOExistente = clienteRepository.findByEmail(clienteDTO.getEmail());
//        if (clienteDTOExistente != null && !clienteDTOExistente.equals(clienteDTO)){
//            throw new Exception();
//        }
        return clienteRepository.save(clienteDTOExistente);
    }

    @Override
    public Void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
