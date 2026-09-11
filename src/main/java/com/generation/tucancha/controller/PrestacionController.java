package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.PrestacionRequest;
import com.generation.tucancha.dto.response.PrestacionResponse;
import com.generation.tucancha.service.PrestacionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestaciones")
public class PrestacionController {

    private final PrestacionService prestacionService;

    public PrestacionController(PrestacionService prestacionService) {
        this.prestacionService = prestacionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrestacionResponse crear(
            @RequestBody PrestacionRequest request
    ) {
        return prestacionService.crear(request);
    }

    @GetMapping
    public List<PrestacionResponse> obtenerTodos() {
        return prestacionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public PrestacionResponse obtenerPorId(
            @PathVariable Long id
    ) {
        return prestacionService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public PrestacionResponse actualizar(
            @PathVariable Long id,
            @RequestBody PrestacionRequest request
    ) {
        return prestacionService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(
            @PathVariable Long id
    ) {
        prestacionService.eliminar(id);
    }
}