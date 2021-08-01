package com.trnetwork.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName ="student_sequence",
			allocationSize = 1 )
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence")
	private Long id;
	/*Is everything that we have need here */
	private String name;
	private String email;
	private LocalDate dof;
	@Transient
	private Integer age;
	
	public Student() {
		
	}

	public Student(Long id, 
			String name, 
			String email,
			LocalDate dof
		) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.dof = dof;

	}

	public Student(String name, String email, LocalDate dof) {
		
		this.name = name;
		this.email = email;
		this.dof = dof;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDof() {
		return dof;
	}

	public void setDof(LocalDate dof) {
		this.dof = dof;
	}

	public Integer getAge() {
		
		return Period.between(this.dof, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student ["
				+ "id=" + id + 
				", name='" + name + '\''+
				", email='" + email +'\''+ 
				", dof=" + dof + "]";
	}
		
	
	
}