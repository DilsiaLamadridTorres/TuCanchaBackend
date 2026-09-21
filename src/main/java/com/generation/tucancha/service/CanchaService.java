package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.CanchaRequestDTO;
import com.generation.tucancha.dto.response.CanchaResponseDTO;
import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.enums.EstadoCancha;
import com.generation.tucancha.repository.CanchaRepository;
import com.generation.tucancha.repository.ComplejoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CanchaService {

    private final CanchaRepository canchaRepository;
    private final ComplejoRepository complejoRepository;

    public CanchaService(
            CanchaRepository canchaRepository,
            ComplejoRepository complejoRepository
    ) {
        this.canchaRepository = canchaRepository;
        this.complejoRepository = complejoRepository;
    }

    // ==========================================
    // CREAR CANCHA
    // ==========================================

    public CanchaResponseDTO crear(CanchaRequestDTO request) {

        Complejo complejo = complejoRepository.findById(request.getIdComplejo())
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe el complejo con id: " + request.getIdComplejo()
                        )
                );

        Cancha cancha = new Cancha();

        cancha.setComplejo(complejo);
        cancha.setNombre(request.getNombre());
        cancha.setDeporte(request.getDeporte());
        cancha.setTipoPiso(request.getTipoPiso());
        cancha.setLargo(request.getLargo());
        cancha.setAncho(request.getAncho());
        cancha.setPrecioHora(request.getPrecioHora());
        cancha.setDuracionMinutos(request.getDuracionMinutos());
        cancha.setTechada(request.getTechada());
        cancha.setOtrosDeportes(
                request.getOtrosDeportes() != null
                        ? request.getOtrosDeportes()
                        : false
        );

        cancha.setEstado(
                request.getEstado() != null
                        ? request.getEstado()
                        : EstadoCancha.PENDIENTE
        );

        Cancha canchaGuardada = canchaRepository.save(cancha);

        return convertirAResponse(canchaGuardada);
    }

    // ==========================================
    // OBTENER TODAS
    // ==========================================

    @Transactional(readOnly = true)
    public List<CanchaResponseDTO> obtenerTodas() {

        return canchaRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    // ==========================================
    // OBTENER POR ID
    // ==========================================

    @Transactional(readOnly = true)
    public CanchaResponseDTO obtenerPorId(Long id) {

        Cancha cancha = canchaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe la cancha con id: " + id
                        )
                );

        return convertirAResponse(cancha);
    }

    // ==========================================
    // ACTUALIZAR
    // ==========================================

    public CanchaResponseDTO actualizar(
            Long id,
            CanchaRequestDTO request
    ) {

        Cancha cancha = canchaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe la cancha con id: " + id
                        )
                );

        Complejo complejo = complejoRepository.findById(request.getIdComplejo())
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe el complejo con id: "
                                        + request.getIdComplejo()
                        )
                );

        cancha.setComplejo(complejo);
        cancha.setNombre(request.getNombre());
        cancha.setDeporte(request.getDeporte());
        cancha.setTipoPiso(request.getTipoPiso());
        cancha.setLargo(request.getLargo());
        cancha.setAncho(request.getAncho());
        cancha.setPrecioHora(request.getPrecioHora());
        cancha.setDuracionMinutos(request.getDuracionMinutos());
        cancha.setTechada(request.getTechada());

        if (request.getOtrosDeportes() != null) {
            cancha.setOtrosDeportes(request.getOtrosDeportes());
        }

        if (request.getEstado() != null) {
            cancha.setEstado(request.getEstado());
        }

        Cancha canchaActualizada = canchaRepository.save(cancha);

        return convertirAResponse(canchaActualizada);
    }

    // ==========================================
    // ELIMINAR
    // ==========================================

    public void eliminar(Long id) {

        Cancha cancha = canchaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe la cancha con id: " + id
                        )
                );

        canchaRepository.delete(cancha);
    }

    // ==========================================
    // MÉTODO PRIVADO - ENTITY -> RESPONSE DTO
    // ==========================================

    private CanchaResponseDTO convertirAResponse(Cancha cancha) {

        CanchaResponseDTO response = new CanchaResponseDTO();

        response.setIdCancha(cancha.getIdCancha());
        response.setIdComplejo(cancha.getIdComplejo());
        response.setNombre(cancha.getNombre());
        response.setDeporte(cancha.getDeporte());
        response.setTipoPiso(cancha.getTipoPiso());
        response.setLargo(cancha.getLargo());
        response.setAncho(cancha.getAncho());
        response.setPrecioHora(cancha.getPrecioHora());
        response.setDuracionMinutos(cancha.getDuracionMinutos());
        response.setTechada(cancha.getTechada());
        response.setOtrosDeportes(cancha.getOtrosDeportes());
        response.setEstado(cancha.getEstado());
        response.setDescripcion(cancha.getDescripcion());
        response.setDisponible(cancha.getDisponible());

        return response;
    }
}