package com.generation.tucancha.repository;

import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.enums.EstadoCancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Long> {
    List<Cancha> findByEstado(EstadoCancha estado);
}