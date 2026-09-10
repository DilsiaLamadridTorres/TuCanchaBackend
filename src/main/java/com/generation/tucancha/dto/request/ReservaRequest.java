package com.generation.tucancha.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservaRequest {
    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El ID del horario es obligatorio")
    private Long horarioId;
}