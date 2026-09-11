package com.generation.tucancha.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO utilizado para recibir los datos
 * necesarios para crear o actualizar un horario.
 */
public class HorarioRequest {

    /* =========================================================
       CANCHA
       ========================================================= */

    @NotNull(message = "La cancha es obligatoria")
    @Positive(message = "El id de la cancha debe ser mayor que cero")
    private Long canchaId;


    /* =========================================================
       FECHA
       ========================================================= */

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede estar en el pasado")
    private LocalDate fecha;


    /* =========================================================
       HORAS
       ========================================================= */

    @NotNull(message = "La hora de inicio es obligatoria")
    private LocalTime horaInicio;


    @NotNull(message = "La hora de fin es obligatoria")
    private LocalTime horaFin;


    /* =========================================================
       CONSTRUCTOR VACÍO
       ========================================================= */

    public HorarioRequest() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public HorarioRequest(
            Long canchaId,
            LocalDate fecha,
            LocalTime horaInicio,
            LocalTime horaFin
    ) {
        this.canchaId = canchaId;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }


    /* =========================================================
       GETTERS Y SETTERS
       ========================================================= */

    public Long getCanchaId() {
        return canchaId;
    }

    public void setCanchaId(Long canchaId) {
        this.canchaId = canchaId;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }


    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}