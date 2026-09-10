package com.generation.tucancha.dto.response;

import com.generation.tucancha.enums.EstadoReserva;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservaResponse {
    private Long idReserva;
    private Long usuarioId;
    private String nombreUsuario;
    private Long horarioId;
    private LocalDateTime fechaCreacion;
    private EstadoReserva estado;
}