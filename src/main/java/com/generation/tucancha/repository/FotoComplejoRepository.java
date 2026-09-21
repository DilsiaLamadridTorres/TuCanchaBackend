package com.generation.tucancha.repository;

import com.generation.tucancha.model.entity.FotoComplejo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoComplejoRepository extends JpaRepository<FotoComplejo, Long> {

    List<FotoComplejo> findByComplejoId(Long idComplejo);
}