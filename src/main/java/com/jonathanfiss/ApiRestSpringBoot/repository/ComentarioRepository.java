package com.jonathanfiss.ApiRestSpringBoot.repository;

import com.jonathanfiss.ApiRestSpringBoot.domain.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
