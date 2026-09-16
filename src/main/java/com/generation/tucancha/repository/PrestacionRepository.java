package com.generation.tucancha.repository;

import com.generation.tucancha.model.entity.Prestacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestacionRepository extends JpaRepository<Prestacion, Long> {
    boolean existsByNombre (String nombre);
}