package com.generation.tucancha.dto.response;

import com.generation.tucancha.model.enums.EstadoHorario;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO utilizado para devolver la información
 * de un horario.
 */
public class HorarioResponse {

    private Long idHorario;

    private Long canchaId;

    private LocalDate fecha;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    private EstadoHorario estado;


    /* =========================================================
       CONSTRUCTOR VACÍO
       ========================================================= */

    public HorarioResponse() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public HorarioResponse(
            Long idHorario,
            Long canchaId,
            LocalDate fecha,
            LocalTime horaInicio,
            LocalTime horaFin,
            EstadoHorario estado
    ) {
        this.idHorario = idHorario;
        this.canchaId = canchaId;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
    }


    /* =========================================================
       GETTERS Y SETTERS
       ========================================================= */

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

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

    public EstadoHorario getEstado() {
        return estado;
    }

    public void setEstado(EstadoHorario estado) {
        this.estado = estado;
    }
}