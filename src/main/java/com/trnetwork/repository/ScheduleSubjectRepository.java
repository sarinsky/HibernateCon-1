package com.trnetwork.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trnetwork.model.Student;
import com.trnetwork.model.Subject;

@Repository
public interface ScheduleSubjectRepository extends JpaRepository<Subject, Serializable> {

}
