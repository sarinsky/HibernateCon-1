package com.trnetwork.ws;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.trnetwork.model.Student;
import com.trnetwork.repository.StudentRepository;
/*for to define is a bean, we need use the anottation 
 * now knows where to find a bean with componente and the instance in Contoller */
@Service //THIS IS MORE FOR SEMANTICS, READBILITY IS MEANT TO BE A SERVICE CLASS  
public class StudentService {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository =studentRepository;
	}

	public List<Student> getStudent() {
		return  (List<Student>) studentRepository.findAll();
				//studentRepository.findAll();

	/*THIS IS REAALY AWESOME*/
	}
	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository
				.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		System.out.println(student);
		studentRepository.save(student);
//		System.out.println(student);
		
	}

	public void deleteStudent(Long studentId) {
		//studentRepository.findAllById(studentId);
			boolean exists = studentRepository.existsById(studentId);
			if (!exists) {
				throw new IllegalStateException("student with id "+ studentId
						+"doesn't exists");
			}
		studentRepository.deleteById(studentId);
	}
	/*Simple business logic*/
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(studentId)
				.orElseThrow(()->new IllegalStateException(
				"student with id"+studentId+"doesn't exist"));
			
		if (name!= null && name.length()>0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		
		if (email!= null && email.length()>0 && !Objects.equals( student.getEmail(), email)) {
			Optional<Student> studentOptional= studentRepository.findStudentByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("EMAIL TAKEN");
			}
			
			student.setEmail(email);
		}
		
	}
}
