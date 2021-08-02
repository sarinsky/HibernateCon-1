package com.trnetwork.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Rol")
public class Rol {
	
	@Id
	@SequenceGenerator(
			name= "rol_sequence",
			sequenceName = "rol_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "rol_sequence")
	
	private Long id;
	private String name;
	
	
	//@OneToMany(mappedBy = "Rol")
	//@JsonIgnore
	//private List<Student> student;
	public Rol() {
		
	}

	public Rol(Long id, 
			String name) {

		this.id = id;
		this.name = name;
	}

	public Rol(String name) {
		this.name = name;
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
	

	/*public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}*/

	

	@Override
	public String toString() {
		return "Rol [id=" + id + 
				", name=" + name +  "]";
	}
	
	
	
	
	
	
	
}
