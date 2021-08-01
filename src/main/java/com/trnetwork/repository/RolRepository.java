package com.trnetwork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trnetwork.model.Rol;

@Repository
public interface RolRepository 
		extends JpaRepository<Rol, Long> {
	@Query("select r from Rol r where r.name=?1")
	Optional<Rol> findRolByName(String name);
}
