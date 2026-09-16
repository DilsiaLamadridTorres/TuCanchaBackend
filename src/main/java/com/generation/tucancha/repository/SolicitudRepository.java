package com.generation.tucancha.repository;

import com.generation.tucancha.model.entity.Solicitud;
import com.generation.tucancha.model.enums.EstadoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    List<Solicitud> findByEstado (EstadoSolicitud estado);
}

