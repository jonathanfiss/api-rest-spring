package com.jonathanfiss.ApiRestSpringBoot.repository;

import com.jonathanfiss.ApiRestSpringBoot.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServiceRepository extends JpaRepository<OrdemServico,Long > {

}
