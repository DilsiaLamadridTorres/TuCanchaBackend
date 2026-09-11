package com.generation.tucancha.model.enums;
/**
 * Estados posibles de una cancha dentro de TuCancha.
 */
public enum EstadoCancha {

    /**
     * La cancha fue registrada, pero todavía
     * no ha sido habilitada para publicación.
     */
    PENDIENTE,

    /**
     * La cancha está habilitada y puede
     * utilizarse dentro de la plataforma.
     */
    ACTIVA,

    /**
     * La cancha está deshabilitada temporalmente
     * y no debe estar disponible para reservas.
     */
    INACTIVA
}