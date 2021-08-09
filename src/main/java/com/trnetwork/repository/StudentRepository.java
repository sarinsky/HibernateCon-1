package com.trnetwork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trnetwork.model.Rol;
import com.trnetwork.model.Student;

/*This is at repository because this interface is responsible for datas access*/
/*We are going to use this interface in our Service*/
@Repository
public interface StudentRepository 
		extends CrudRepository<Student, Long> {
	//extends CrudRepository<Rol, Long>   extends JpaRepository<Student, Long>
	/*is like selct*from student where email=?*/
	@Query("SELECT s from Student s where s.email=?1")
	Optional<Student> findStudentByEmail(String name);
}
