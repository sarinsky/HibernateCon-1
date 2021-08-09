package com.trnetwork.controller;


import java.time.LocalDate;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.model.Student;
import com.trnetwork.ws.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
/*Alll the resources for our api */
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		/*are not goint to work cause dont have an instance
		 * are goint to be a sprigns bean*/
		this.studentService=studentService;
	}
	
	@GetMapping
	public List<Student> getStudent() {
		return studentService.getStudent();
	}
	@PostMapping
	public void  registerNewStudent(@RequestBody Student student) {
		/*We are going to add a new Student*/
		studentService.addNewStudent(student);
	}
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	
	}
	@PutMapping(path = "{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required=false) String name,
			@RequestParam(required= false) String email) {
			//@RequestParam(required = false) LocalDate dof ) 
		studentService.updateStudent(studentId, name, email);
	}

}
