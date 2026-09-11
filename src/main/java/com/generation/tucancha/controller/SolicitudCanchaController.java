package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.SolicitudCanchaRequest;
import com.generation.tucancha.dto.response.SolicitudCanchaResponse;
import com.generation.tucancha.service.SolicitudCanchaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes-cancha")
public class SolicitudCanchaController {

    private final SolicitudCanchaService solicitudCanchaService;

    public SolicitudCanchaController(
            SolicitudCanchaService solicitudCanchaService
    ) {
        this.solicitudCanchaService = solicitudCanchaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SolicitudCanchaResponse crear(
            @RequestBody SolicitudCanchaRequest request
    ) {
        return solicitudCanchaService.crear(request);
    }

    @GetMapping
    public List<SolicitudCanchaResponse> obtenerTodos() {
        return solicitudCanchaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public SolicitudCanchaResponse obtenerPorId(
            @PathVariable Long id
    ) {
        return solicitudCanchaService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public SolicitudCanchaResponse actualizar(
            @PathVariable Long id,
            @RequestBody SolicitudCanchaRequest request
    ) {
        return solicitudCanchaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        solicitudCanchaService.eliminar(id);
    }
}