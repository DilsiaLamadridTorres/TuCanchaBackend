package com.generation.tucancha.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank(message = "El correo de usuario es obligatorio")
        String correo,

        @NotBlank(message = "La contraseña es obligatoria")
        String password
) {
}