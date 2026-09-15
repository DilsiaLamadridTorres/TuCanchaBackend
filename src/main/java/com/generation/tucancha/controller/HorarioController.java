package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.HorarioRequest;
import com.generation.tucancha.dto.response.HorarioResponse;
import com.generation.tucancha.model.enums.EstadoHorario;
import com.generation.tucancha.service.HorarioService;

import jakarta.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Controlador REST encargado de gestionar
 * los horarios de las canchas.
 */
@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService horarioService;


    /* =========================================================
       INYECCIÓN DE DEPENDENCIAS
       ========================================================= */

    public HorarioController(
            HorarioService horarioService
    ) {
        this.horarioService = horarioService;
    }


    /* =========================================================
       CREAR HORARIO
       POST /api/horarios
       ========================================================= */

    @PostMapping
    public ResponseEntity<HorarioResponse> crearHorario(
            @Valid
            @RequestBody
            HorarioRequest request
    ) {

        HorarioResponse response =
                horarioService.crearHorario(
                        request
                );


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    /* =========================================================
       LISTAR TODOS LOS HORARIOS
       GET /api/horarios
       ========================================================= */

    @GetMapping
    public ResponseEntity<List<HorarioResponse>> listarTodos() {

        List<HorarioResponse> horarios =
                horarioService.listarTodos();


        return ResponseEntity.ok(
                horarios
        );
    }


    /* =========================================================
       OBTENER HORARIO POR ID
       GET /api/horarios/{id}
       ========================================================= */

    @GetMapping("/{id}")
    public ResponseEntity<HorarioResponse> obtenerPorId(
            @PathVariable("id")
            Long idHorario
    ) {

        HorarioResponse response =
                horarioService.obtenerPorId(
                        idHorario
                );


        return ResponseEntity.ok(
                response
        );
    }


    /* =========================================================
       LISTAR HORARIOS POR CANCHA

       GET /api/horarios/cancha/5
       ========================================================= */

    @GetMapping("/cancha/{canchaId}")
    public ResponseEntity<List<HorarioResponse>> listarPorCancha(
            @PathVariable
            Long canchaId
    ) {

        List<HorarioResponse> horarios =
                horarioService.listarPorCancha(
                        canchaId
                );


        return ResponseEntity.ok(
                horarios
        );
    }


    /* =========================================================
       LISTAR HORARIOS POR CANCHA Y FECHA

       Ejemplo:

       GET
       /api/horarios/cancha/5/fecha/2026-09-15
       ========================================================= */

    @GetMapping(
            "/cancha/{canchaId}/fecha/{fecha}"
    )
    public ResponseEntity<List<HorarioResponse>>
    listarPorCanchaYFecha(

            @PathVariable
            Long canchaId,

            @PathVariable
            @DateTimeFormat(
                    iso = DateTimeFormat.ISO.DATE
            )
            LocalDate fecha
    ) {

        List<HorarioResponse> horarios =
                horarioService.listarPorCanchaYFecha(
                        canchaId,
                        fecha
                );


        return ResponseEntity.ok(
                horarios
        );
    }


    /* =========================================================
       LISTAR HORARIOS DISPONIBLES

       Ejemplo:

       GET
       /api/horarios/cancha/5/disponibles?fecha=2026-09-15
       ========================================================= */

    @GetMapping(
            "/cancha/{canchaId}/disponibles"
    )
    public ResponseEntity<List<HorarioResponse>>
    listarDisponibles(

            @PathVariable
            Long canchaId,

            @RequestParam
            @DateTimeFormat(
                    iso = DateTimeFormat.ISO.DATE
            )
            LocalDate fecha
    ) {

        List<HorarioResponse> horarios =
                horarioService.listarDisponibles(
                        canchaId,
                        fecha
                );


        return ResponseEntity.ok(
                horarios
        );
    }


    /* =========================================================
       ACTUALIZAR HORARIO

       PUT /api/horarios/{id}
       ========================================================= */

    @PutMapping("/{id}")
    public ResponseEntity<HorarioResponse> actualizarHorario(

            @PathVariable("id")
            Long idHorario,

            @Valid
            @RequestBody
            HorarioRequest request
    ) {

        HorarioResponse response =
                horarioService.actualizarHorario(
                        idHorario,
                        request
                );


        return ResponseEntity.ok(
                response
        );
    }


    /* =========================================================
       CAMBIAR ESTADO

       Ejemplo:

       PATCH
       /api/horarios/10/estado?estado=BLOQUEADO
       ========================================================= */

    @PatchMapping("/{id}/estado")
    public ResponseEntity<HorarioResponse> cambiarEstado(

            @PathVariable("id")
            Long idHorario,

            @RequestParam
            EstadoHorario estado
    ) {

        HorarioResponse response =
                horarioService.cambiarEstado(
                        idHorario,
                        estado
                );


        return ResponseEntity.ok(
                response
        );
    }


    /* =========================================================
       ELIMINAR HORARIO

       DELETE /api/horarios/{id}
       ========================================================= */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(
            @PathVariable("id")
            Long idHorario
    ) {

        horarioService.eliminarHorario(
                idHorario
        );


        return ResponseEntity
                .noContent()
                .build();
    }
}