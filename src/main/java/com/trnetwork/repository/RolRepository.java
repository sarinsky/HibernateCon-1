package com.trnetwork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trnetwork.model.Rol;

@Repository
public interface RolRepository 
	extends CrudRepository<Rol, Long> {
	//@Query("select r from Rol r where r.name=?1") extends Crud extends JpaRepository<Rol, Long> 
	Optional<Rol> findRolByName(String name);
}
