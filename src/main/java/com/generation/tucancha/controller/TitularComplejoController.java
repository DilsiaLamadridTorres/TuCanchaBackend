package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.TitularComplejoRequest;
import com.generation.tucancha.dto.response.TitularComplejoResponse;
import com.generation.tucancha.service.TitularComplejoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titulares")
@CrossOrigin(origins = "*")
public class TitularComplejoController {

    private final TitularComplejoService titularComplejoService;

    public TitularComplejoController(
            TitularComplejoService titularComplejoService) {

        this.titularComplejoService = titularComplejoService;
    }

    @PostMapping
    public ResponseEntity<TitularComplejoResponse> crear(
            @RequestBody TitularComplejoRequest request) {

        return ResponseEntity.ok(
                titularComplejoService.crear(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<TitularComplejoResponse>> obtenerTodos() {

        return ResponseEntity.ok(
                titularComplejoService.obtenerTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitularComplejoResponse> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                titularComplejoService.obtenerPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TitularComplejoResponse> actualizar(
            @PathVariable Long id,
            @RequestBody TitularComplejoRequest request) {

        return ResponseEntity.ok(
                titularComplejoService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        titularComplejoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}