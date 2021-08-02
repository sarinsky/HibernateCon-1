package com.trnetwork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trnetwork.model.Subject;

@Repository
public interface SubjectRepository 
	extends JpaRepository<Subject, Long> {
	//@Query("Select s from Subject s where s.name=?1")
	Optional<Subject> findSubjectByName(String name);
}
