package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.PrestacionRequest;
import com.generation.tucancha.dto.response.PrestacionResponse;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.entity.Prestacion;
import com.generation.tucancha.repository.ComplejoRepository;
import com.generation.tucancha.repository.PrestacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestacionService {

    private final PrestacionRepository prestacionRepository;
    private final ComplejoRepository complejoRepository;

    public PrestacionService(
            PrestacionRepository prestacionRepository,
            ComplejoRepository complejoRepository
    ) {
        this.prestacionRepository = prestacionRepository;
        this.complejoRepository = complejoRepository;
    }


    public PrestacionResponse crear(PrestacionRequest request) {

        Complejo complejo = complejoRepository
                .findById(request.getComplejoId())
                .orElseThrow(() ->
                        new RuntimeException("Complejo no encontrado")
                );

        Prestacion prestacion = new Prestacion(
                request.getNombre(),
                complejo
        );

        Prestacion prestacionGuardada =
                prestacionRepository.save(prestacion);

        return convertirAResponse(prestacionGuardada);
    }


    public List<PrestacionResponse> obtenerTodos() {

        return prestacionRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public PrestacionResponse obtenerPorId(Long id) {

        Prestacion prestacion = prestacionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Prestación no encontrada")
                );

        return convertirAResponse(prestacion);
    }

    public PrestacionResponse actualizar(
            Long id,
            PrestacionRequest request
    ) {

        Prestacion prestacion = prestacionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Prestación no encontrada")
                );

        Complejo complejo = complejoRepository
                .findById(request.getComplejoId())
                .orElseThrow(() ->
                        new RuntimeException("Complejo no encontrado")
                );

        prestacion.setNombre(request.getNombre());
        prestacion.setComplejo(complejo);

        Prestacion prestacionActualizada =
                prestacionRepository.save(prestacion);

        return convertirAResponse(prestacionActualizada);
    }

    public void eliminar(Long id) {

        Prestacion prestacion = prestacionRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Prestación no encontrada")
                );

        prestacionRepository.delete(prestacion);
    }


    private PrestacionResponse convertirAResponse(
            Prestacion prestacion
    ) {

        return new PrestacionResponse(
                prestacion.getId(),
                prestacion.getNombre(),
                prestacion.getComplejo().getId()
        );
    }

}
