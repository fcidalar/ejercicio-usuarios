package com.ejercicio.usuarios.service;

import java.util.List;

import com.ejercicio.usuarios.dto.UsuarioRequestDTO;
import com.ejercicio.usuarios.dto.UsuarioResponseDTO;

public interface UsuarioService {

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioRequestDTO);

    List<UsuarioRequestDTO> buscarPorNombre(String nombre);
}
