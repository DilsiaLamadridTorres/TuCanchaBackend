package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.CanchaRequestDTO;
import com.generation.tucancha.dto.response.CanchaResponseDTO;
import com.generation.tucancha.service.CanchaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canchas")
@CrossOrigin(origins = "*")
public class CanchaController {

    private final CanchaService canchaService;

    public CanchaController(CanchaService canchaService) {
        this.canchaService = canchaService;
    }

    // ==========================================
    // POST - CREAR
    // ==========================================

    @PostMapping
    public ResponseEntity<CanchaResponseDTO> crear(
            @Valid @RequestBody CanchaRequestDTO request
    ) {

        CanchaResponseDTO response = canchaService.crear(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // ==========================================
    // GET - TODAS
    // ==========================================

    @GetMapping
    public ResponseEntity<List<CanchaResponseDTO>> obtenerTodas() {

        return ResponseEntity.ok(
                canchaService.obtenerTodas()
        );
    }

    // ==========================================
    // GET - POR ID
    // ==========================================

    @GetMapping("/{id}")
    public ResponseEntity<CanchaResponseDTO> obtenerPorId(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                canchaService.obtenerPorId(id)
        );
    }

    // ==========================================
    // PUT - ACTUALIZAR
    // ==========================================

    @PutMapping("/{id}")
    public ResponseEntity<CanchaResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CanchaRequestDTO request
    ) {

        return ResponseEntity.ok(
                canchaService.actualizar(id, request)
        );
    }

    // ==========================================
    // DELETE - ELIMINAR
    // ==========================================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id
    ) {

        canchaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}