package com.jonathanfiss.ApiRestSpringBoot.repository;

import com.jonathanfiss.ApiRestSpringBoot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
