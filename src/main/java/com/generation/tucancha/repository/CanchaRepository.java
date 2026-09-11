package com.generation.tucancha.repository;

import com.generation.tucancha.model.entity.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanchaRepository extends JpaRepository<Cancha, Long> {
}