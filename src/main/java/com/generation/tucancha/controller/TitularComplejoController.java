package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.TitularComplejoRequest;
import com.generation.tucancha.dto.response.TitularComplejoResponse;
import com.generation.tucancha.service.TitularComplejoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titulares")
public class TitularComplejoController {

    private final TitularComplejoService titularComplejoService;

    public TitularComplejoController(
            TitularComplejoService titularComplejoService
    ) {
        this.titularComplejoService = titularComplejoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TitularComplejoResponse crear(
            @RequestBody TitularComplejoRequest request
    ) {
        return titularComplejoService.crear(request);
    }

    @GetMapping
    public List<TitularComplejoResponse> obtenerTodos() {
        return titularComplejoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public TitularComplejoResponse obtenerPorId(
            @PathVariable Long id
    ) {
        return titularComplejoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public TitularComplejoResponse actualizar(
            @PathVariable Long id,
            @RequestBody TitularComplejoRequest request
    ) {
        return titularComplejoService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(
            @PathVariable Long id
    ) {
        titularComplejoService.eliminar(id);
    }
}