package com.generation.tucancha.service;

import com.generation.tucancha.model.entity.Solicitud;
import com.generation.tucancha.model.enums.EstadoSolicitud;
import com.generation.tucancha.repository.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public SolicitudService (SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public List<Solicitud> obtenerTodas ( ) {
        return solicitudRepository.findAll();
    }

    public List<Solicitud> obtenerPorEstado (EstadoSolicitud estado) {
        return solicitudRepository.findByEstado(estado);
    }

    public Solicitud guardar (Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
}