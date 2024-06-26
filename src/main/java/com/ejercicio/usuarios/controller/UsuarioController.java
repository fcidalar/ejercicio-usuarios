package com.ejercicio.usuarios.controller;

import com.ejercicio.usuarios.dto.UsuarioRequestDTO;
import com.ejercicio.usuarios.dto.UsuarioResponseDTO;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UsuarioController {
    ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO);

    ResponseEntity<List<UsuarioRequestDTO>> buscarUsuariosPorNombre(@RequestBody String nombre);
}
