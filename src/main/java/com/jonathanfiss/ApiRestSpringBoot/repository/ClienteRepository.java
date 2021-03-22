package com.jonathanfiss.ApiRestSpringBoot.repository;

import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteDTO;
import com.jonathanfiss.ApiRestSpringBoot.dto.ClienteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteResponseDTO, Long> {
    List<ClienteResponseDTO> findByNome(String nome);
    List<ClienteResponseDTO> findByNomeContaining(String nome);
    ClienteResponseDTO findByEmail(String email);
}
