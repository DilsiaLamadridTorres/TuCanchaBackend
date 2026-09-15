package com.generation.tucancha.repository;

import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.entity.Horario;
import com.generation.tucancha.model.enums.EstadoHorario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * Repositorio encargado del acceso a datos
 * de los horarios de las canchas.
 */
@Repository
public interface HorarioRepository
        extends JpaRepository<Horario, Long> {


    /* =========================================================
       HORARIOS POR CANCHA
       ========================================================= */

    /**
     * Obtiene todos los horarios registrados
     * para una cancha.
     */
    List<Horario> findByCancha(
            Cancha cancha
    );


    /* =========================================================
       HORARIOS POR CANCHA Y FECHA
       ========================================================= */

    /**
     * Obtiene los horarios de una cancha
     * para un día específico.
     */
    List<Horario> findByCanchaAndFecha(
            Cancha cancha,
            LocalDate fecha
    );


    /* =========================================================
       HORARIOS POR CANCHA, FECHA Y ESTADO
       ========================================================= */

    /**
     * Permite consultar, por ejemplo,
     * solamente los horarios DISPONIBLES
     * de una cancha en una fecha.
     */
    List<Horario> findByCanchaAndFechaAndEstado(
            Cancha cancha,
            LocalDate fecha,
            EstadoHorario estado
    );


    /* =========================================================
       VALIDAR SOLAPAMIENTO DE HORARIOS
       ========================================================= */

    /**
     * Verifica si ya existe un horario que se cruce
     * con el nuevo horario que queremos registrar.
     *
     * Ejemplo:
     *
     * Existente:
     * 08:00 -------- 09:00
     *
     * Nuevo:
     *        08:30 -------- 09:30
     *
     * Resultado:
     * true
     *
     * Hay solapamiento.
     */
    @Query("""
            SELECT CASE
                WHEN COUNT(h) > 0 THEN true
                ELSE false
            END
            FROM Horario h
            WHERE h.cancha = :cancha
              AND h.fecha = :fecha
              AND h.horaInicio < :horaFin
              AND h.horaFin > :horaInicio
            """)
    boolean existeSolapamiento(
            @Param("cancha") Cancha cancha,
            @Param("fecha") LocalDate fecha,
            @Param("horaInicio") LocalTime horaInicio,
            @Param("horaFin") LocalTime horaFin
    );

    /* =========================================================
   VALIDAR SOLAPAMIENTO AL ACTUALIZAR
   ========================================================= */

    /**
     * Verifica si existe otro horario que se cruce
     * con el horario que estamos actualizando.
     *
     * Se excluye el horario actual mediante su ID.
     */
    @Query("""
        SELECT CASE
            WHEN COUNT(h) > 0 THEN true
            ELSE false
        END
        FROM Horario h
        WHERE h.cancha = :cancha
          AND h.fecha = :fecha
          AND h.idHorario <> :idHorario
          AND h.horaInicio < :horaFin
          AND h.horaFin > :horaInicio
        """)
    boolean existeSolapamientoExcluyendoHorario(
            @Param("cancha") Cancha cancha,
            @Param("fecha") LocalDate fecha,
            @Param("horaInicio") LocalTime horaInicio,
            @Param("horaFin") LocalTime horaFin,
            @Param("idHorario") Long idHorario
    );
}