package com.ejercicio.usuarios.dto;

import lombok.Data;
import java.util.List;

@Data
public class UsuarioRequestDTO {
    private String name;
    private String email;
    private String password;
    private List<TelefonoDTO> phones;
}