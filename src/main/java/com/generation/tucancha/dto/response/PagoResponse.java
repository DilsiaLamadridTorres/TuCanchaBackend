package com.generation.tucancha.dto.response;

import com.generation.tucancha.enums.EstadoPago;
import com.generation.tucancha.enums.MetodoPago;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PagoResponse {
    private Long idPago;
    private Long reservaId;
    private MetodoPago metodoPago;
    private Double monto;
    private EstadoPago estado;
    private LocalDateTime fechaPago;
}