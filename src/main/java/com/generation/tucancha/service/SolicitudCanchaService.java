package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.SolicitudCanchaRequest;
import com.generation.tucancha.dto.response.SolicitudCanchaResponse;

import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.entity.Solicitud;
import com.generation.tucancha.model.entity.SolicitudCancha;

import com.generation.tucancha.repository.CanchaRepository;
import com.generation.tucancha.repository.SolicitudCanchaRepository;
import com.generation.tucancha.repository.SolicitudRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudCanchaService {

    private final SolicitudCanchaRepository solicitudCanchaRepository;
    private final SolicitudRepository solicitudRepository;
    private final CanchaRepository canchaRepository;

    public SolicitudCanchaService(
            SolicitudCanchaRepository solicitudCanchaRepository,
            SolicitudRepository solicitudRepository,
            CanchaRepository canchaRepository
    ) {
        this.solicitudCanchaRepository = solicitudCanchaRepository;
        this.solicitudRepository = solicitudRepository;
        this.canchaRepository = canchaRepository;
    }

    public SolicitudCanchaResponse crear(SolicitudCanchaRequest request) {

        Solicitud solicitud = solicitudRepository
                .findById(request.getSolicitudId())
                .orElseThrow(() ->
                        new RuntimeException("Solicitud no encontrada")
                );

        Cancha cancha = canchaRepository
                .findById(request.getCanchaId())
                .orElseThrow(() ->
                        new RuntimeException("Cancha no encontrada")
                );

        SolicitudCancha solicitudCancha = new SolicitudCancha(
                solicitud,
                cancha
        );

        SolicitudCancha solicitudCanchaGuardada =
                solicitudCanchaRepository.save(solicitudCancha);

        return convertirAResponse(solicitudCanchaGuardada);
    }


    public List<SolicitudCanchaResponse> obtenerTodos() {

        return solicitudCanchaRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public SolicitudCanchaResponse obtenerPorId(Long id) {

        SolicitudCancha solicitudCancha = solicitudCanchaRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("SolicitudCancha no encontrada")
                );

        return convertirAResponse(solicitudCancha);
    }

    public SolicitudCanchaResponse actualizar(
            Long id,
            SolicitudCanchaRequest request
    ) {

        SolicitudCancha solicitudCancha = solicitudCanchaRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("SolicitudCancha no encontrada")
                );

        Solicitud solicitud = solicitudRepository
                .findById(request.getSolicitudId())
                .orElseThrow(() ->
                        new RuntimeException("Solicitud no encontrada")
                );

        Cancha cancha = canchaRepository
                .findById(request.getCanchaId())
                .orElseThrow(() ->
                        new RuntimeException("Cancha no encontrada")
                );

        solicitudCancha.setSolicitud(solicitud);
        solicitudCancha.setCancha(cancha);

        SolicitudCancha solicitudCanchaActualizada =
                solicitudCanchaRepository.save(solicitudCancha);

        return convertirAResponse(solicitudCanchaActualizada);
    }


    public void eliminar(Long id) {

        SolicitudCancha solicitudCancha = solicitudCanchaRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("SolicitudCancha no encontrada")
                );

        solicitudCanchaRepository.delete(solicitudCancha);
    }

    private SolicitudCanchaResponse convertirAResponse(
            SolicitudCancha solicitudCancha
    ) {

        return new SolicitudCanchaResponse(
                solicitudCancha.getId(),
                solicitudCancha.getSolicitud().getId(),
                solicitudCancha.getCancha().getId()
        );
    }


}