package com.jonathanfiss.ApiRestSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 60)
    private String nome;
    @NotBlank(message = "E-mail is mandatory")
    @Email
    @Size(max = 255)
    private String email;
    @NotBlank(message = "Telefone is mandatory")
    @Size(min = 11, max = 12)
    private String telefone;
}
