package com.generation.tucancha.model.enums;

/**
 * Estados posibles de un horario asociado a una cancha.
 */
public enum EstadoHorario {

    /**
     * El horario se encuentra libre
     * y puede ser reservado.
     */
    DISPONIBLE,

    /**
     * El horario ya está asociado
     * a una reserva.
     */
    RESERVADO,

    /**
     * El horario fue bloqueado por el complejo
     * y no puede ser reservado.
     */
    BLOQUEADO
}