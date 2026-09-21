package com.generation.tucancha.dto.response;

import com.generation.tucancha.model.enums.RolUsuario;

public record LoginResponseDTO(
        String token,
        String nombre,
        RolUsuario rol
) {
}
