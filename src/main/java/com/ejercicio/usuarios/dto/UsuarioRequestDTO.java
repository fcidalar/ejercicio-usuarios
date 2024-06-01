package com.ejercicio.usuarios.dto;

import lombok.Data;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class UsuarioRequestDTO {
    @NotBlank(message = "no puede ir nulo")
    private String name;

    @NotBlank(message = "no puede ir nulo")
    @Email(message = "Formato Invalido", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotBlank(message = "no puede ir nulo")
    private String password;
    private List<TelefonoDTO> phones;
}