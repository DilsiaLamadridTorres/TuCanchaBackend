package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.PagoRequest;
import com.generation.tucancha.dto.response.PagoResponse;
import com.generation.tucancha.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<PagoResponse>> obtenerTodos() {
        return ResponseEntity.ok(pagoService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<PagoResponse> registrarPago(@Valid @RequestBody PagoRequest request) {
        return new ResponseEntity<>(pagoService.registrarPago(request), HttpStatus.CREATED);
    }
}