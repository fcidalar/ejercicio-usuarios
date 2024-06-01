package com.ejercicio.usuarios.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.usuarios.controller.UsuarioController;
import com.ejercicio.usuarios.dto.UsuarioRequestDTO;
import com.ejercicio.usuarios.dto.UsuarioResponseDTO;
import com.ejercicio.usuarios.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuarioRequestDTO), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioRequestDTO>> buscarUsuariosPorNombre(@RequestParam String nombre) {
        return new ResponseEntity<>(usuarioService.buscarPorNombre(nombre), HttpStatus.OK);
    }

}
