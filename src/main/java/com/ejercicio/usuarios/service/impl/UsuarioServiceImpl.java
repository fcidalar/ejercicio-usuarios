package com.ejercicio.usuarios.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.ejercicio.usuarios.dto.UsuarioRequestDTO;
import com.ejercicio.usuarios.dto.UsuarioResponseDTO;
import com.ejercicio.usuarios.model.Usuario;
import com.ejercicio.usuarios.repository.UsuarioRepository;
import com.ejercicio.usuarios.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final ModelMapper modelMapper;
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
            ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        log.info("[UsuarioServiceImpl]::inicio de servicio");

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioRequestDTO.getEmail());
        if (usuarioExistente.isPresent()) {
            log.error("El correo ya está registrado");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo ya está registrado");
        }

        Usuario usuario = modelMapper.map(usuarioRequestDTO, Usuario.class);
        usuario.setId(UUID.randomUUID());
        usuario.setCreated(LocalDateTime.now());
        usuario.setLastLogin(LocalDateTime.now());
        usuario.setToken("token");
        usuario.setActive(true);
        try {
            usuarioRepository.save(usuario);

            log.info("[UsuarioServiceImpl]::fin de servicio");
            return modelMapper.map(usuario, UsuarioResponseDTO.class);

        } catch (Exception e) {
            log.error("Error al crear el usuario: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el usuario: " + e.getMessage());
        }

    }

}
