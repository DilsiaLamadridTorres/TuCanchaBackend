package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.PrestacionRequestDTO;
import com.generation.tucancha.dto.response.PrestacionResponseDTO;
import com.generation.tucancha.model.entity.Prestacion;
import com.generation.tucancha.repository.PrestacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestacionService {

    private final PrestacionRepository prestacionRepository;

    public PrestacionService(PrestacionRepository prestacionRepository) {
        this.prestacionRepository = prestacionRepository;
    }

    @Transactional(readOnly = true)
    public List<PrestacionResponseDTO> obtenerTodas() {
        return prestacionRepository.findAll().stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PrestacionResponseDTO obtenerPorId(Long id) {
        Prestacion prestacion = prestacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestación no encontrada con id: " + id));
        return convertirAResponseDTO(prestacion);
    }

    @Transactional
    public PrestacionResponseDTO crear(PrestacionRequestDTO request) {
        if (prestacionRepository.existsByNombre(request.getNombre())) {
            throw new IllegalArgumentException("Ya existe una prestación con el nombre: " + request.getNombre());
        }

        Prestacion prestacion = new Prestacion();
        prestacion.setNombre(request.getNombre());
        prestacion.setDescripcion(request.getDescripcion());

        Prestacion guardada = prestacionRepository.save(prestacion);
        return convertirAResponseDTO(guardada);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!prestacionRepository.existsById(id)) {
            throw new RuntimeException("No se encontró la prestación a eliminar");
        }
        prestacionRepository.deleteById(id);
    }

    private PrestacionResponseDTO convertirAResponseDTO(Prestacion prestacion) {
        return new PrestacionResponseDTO(
                prestacion.getId(),
                prestacion.getNombre(),
                prestacion.getDescripcion()
        );
    }
}