package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.CanchaRequest;
import com.generation.tucancha.dto.response.CanchaResponse;
import com.generation.tucancha.model.enums.EstadoCancha;
import com.generation.tucancha.service.CanchaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador REST encargado de gestionar
 * las operaciones relacionadas con las canchas.
 */
@RestController
@RequestMapping("/api/canchas")
public class CanchaController {

    private final CanchaService canchaService;


    /* =========================================================
       INYECCIÓN DE DEPENDENCIAS
       ========================================================= */

    public CanchaController(
            CanchaService canchaService
    ) {
        this.canchaService = canchaService;
    }


    /* =========================================================
       CREAR CANCHA
       POST /api/canchas
       ========================================================= */

    @PostMapping
    public ResponseEntity<CanchaResponse> crearCancha(
            @Valid
            @RequestBody
            CanchaRequest request
    ) {

        CanchaResponse response =
                canchaService.crearCancha(
                        request
                );


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    /* =========================================================
       LISTAR TODAS LAS CANCHAS
       GET /api/canchas
       ========================================================= */

    @GetMapping
    public ResponseEntity<List<CanchaResponse>> listarTodas() {

        List<CanchaResponse> canchas =
                canchaService.listarTodas();


        return ResponseEntity.ok(
                canchas
        );
    }


    /* =========================================================
       OBTENER CANCHA POR ID
       GET /api/canchas/{id}
       ========================================================= */

    @GetMapping("/{id}")
    public ResponseEntity<CanchaResponse> obtenerPorId(
            @PathVariable("id")
            Long idCancha
    ) {

        CanchaResponse response =
                canchaService.obtenerPorId(
                        idCancha
                );


        return ResponseEntity.ok(
                response
        );
    }


    /* =========================================================
       LISTAR CANCHAS POR COMPLEJO
       GET /api/canchas/complejo/{complejoId}
       ========================================================= */

    @GetMapping("/complejo/{complejoId}")
    public ResponseEntity<List<CanchaResponse>> listarPorComplejo(
            @PathVariable
            Long complejoId
    ) {

        List<CanchaResponse> canchas =
                canchaService.listarPorComplejo(
                        complejoId
                );


        return ResponseEntity.ok(
                canchas
        );
    }


    /* =========================================================
       LISTAR CANCHAS POR ESTADO

       Ejemplo:
       GET /api/canchas/estado/ACTIVA
       ========================================================= */

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CanchaResponse>> listarPorEstado(
            @PathVariable
            EstadoCancha estado
    ) {

        List<CanchaResponse> canchas =
                canchaService.listarPorEstado(
                        estado
                );


        return ResponseEntity.ok(
                canchas
        );
    }


    /* =========================================================
       ACTUALIZAR CANCHA
       PUT /api/canchas/{id}
       ========================================================= */

    @PutMapping("/{id}")
    public ResponseEntity<CanchaResponse> actualizarCancha(
            @PathVariable("id")
            Long idCancha,

            @Valid
            @RequestBody
            CanchaRequest request
    ) {

        CanchaResponse response =
                canchaService.actualizarCancha(
                        idCancha,
                        request
                );


        return ResponseEntity.ok(
                response
        );
    }


    /* =========================================================
       CAMBIAR ESTADO DE LA CANCHA

       Ejemplo:
       PATCH /api/canchas/5/estado?estado=ACTIVA
       ========================================================= */

    @PatchMapping("/{id}/estado")
    public ResponseEntity<CanchaResponse> cambiarEstado(
            @PathVariable("id")
            Long idCancha,

            @RequestParam
            EstadoCancha estado
    ) {

        CanchaResponse response =
                canchaService.cambiarEstado(
                        idCancha,
                        estado
                );


        return ResponseEntity.ok(
                response
        );
    }
}