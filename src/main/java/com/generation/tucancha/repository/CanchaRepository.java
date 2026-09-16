package com.generation.tucancha.repository;

import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.enums.EstadoCancha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repositorio encargado del acceso a datos
 * de la entidad Cancha.
 */
@Repository
public interface CanchaRepository
        extends JpaRepository<Cancha, Long> {


    /* =========================================================
       BUSCAR CANCHAS POR COMPLEJO
       ========================================================= */

    /**
     * Retorna todas las canchas pertenecientes
     * a un complejo deportivo.
     *
     * Usamos directamente el objeto Complejo para no depender
     * todavía del nombre exacto que Dilsia utilice para su ID.
     */
    List<Cancha> findByComplejo(Complejo complejo);


    /* =========================================================
       BUSCAR CANCHAS POR ESTADO
       ========================================================= */

    /**
     * Permite obtener canchas según su estado.
     *
     * Ejemplos:
     * ACTIVA
     * INACTIVA
     * PENDIENTE
     */
    List<Cancha> findByEstado(EstadoCancha estado);


    /* =========================================================
       BUSCAR POR COMPLEJO Y ESTADO
       ========================================================= */

    /**
     * Retorna las canchas de un complejo
     * filtradas por estado.
     */
    List<Cancha> findByComplejoAndEstado(
            Complejo complejo,
            EstadoCancha estado
    );


    /* =========================================================
       BUSCAR POR NOMBRE
       ========================================================= */

    /**
     * Busca canchas cuyo nombre contenga
     * el texto enviado.
     *
     * IgnoreCase hace que no importe si viene:
     *
     * "Arena"
     * "arena"
     * "ARENA"
     */
    List<Cancha> findByNombreContainingIgnoreCase(
            String nombre
    );
}