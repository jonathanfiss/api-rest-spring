package com.jonathanfiss.ApiRestSpringBoot.dto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class ClienteDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 60)
    private String nome;
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;
    @NotBlank
    @Size(min = 11, max = 12)
    private String telefone;

}