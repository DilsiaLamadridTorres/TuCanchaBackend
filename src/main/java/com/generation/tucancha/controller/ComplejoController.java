package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.ComplejoRequest;
import com.generation.tucancha.dto.response.ComplejoResponse;
import com.generation.tucancha.service.ComplejoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complejos")
public class ComplejoController {

    private final ComplejoService complejoService;

    public ComplejoController(ComplejoService complejoService) {
        this.complejoService = complejoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComplejoResponse crear(
            @RequestBody ComplejoRequest request
    ) {
        return complejoService.crear(request);
    }

    @GetMapping
    public List<ComplejoResponse> obtenerTodos() {
        return complejoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ComplejoResponse obtenerPorId(
            @PathVariable Long id
    ) {
        return complejoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ComplejoResponse actualizar(
            @PathVariable Long id,
            @RequestBody ComplejoRequest request
    ) {
        return complejoService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(
            @PathVariable Long id
    ) {
        complejoService.eliminar(id);
    }
}