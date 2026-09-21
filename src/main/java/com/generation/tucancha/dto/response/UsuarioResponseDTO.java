package com.generation.tucancha.dto.response;

import com.generation.tucancha.model.enums.RolUsuario;

public record UsuarioResponseDTO(
        Long id,
        String nombre,
        String correo,
        RolUsuario rol
) {}