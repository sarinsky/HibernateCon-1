package com.trnetwork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trnetwork.model.HorarioMateria;

@Repository
public interface HMateriaRepository 
	extends JpaRepository<HorarioMateria, Long> {
	Optional<HorarioMateria> findHorarioMateriaById(Long id);

	//HorarioMateria save(HorarioMateria horarioMateria, boolean b);
}
