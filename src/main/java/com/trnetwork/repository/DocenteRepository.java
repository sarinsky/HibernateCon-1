package com.trnetwork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trnetwork.model.Docente;

@Repository
public interface DocenteRepository 
	extends JpaRepository<Docente, Long> {
	//@Query("Select d from Docente d where d.email=?1")
	Optional<Docente> findDocenteByEmail(String email);

}
