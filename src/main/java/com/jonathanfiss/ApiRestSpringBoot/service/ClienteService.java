package com.jonathanfiss.ApiRestSpringBoot.service;

import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteRequestDTO;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteResponseDTO;

public interface ClienteService {

    ClienteResponseDTO salvar(ClienteRequestDTO clienteDTO);

    Void excluir(Long clienteId);

}
