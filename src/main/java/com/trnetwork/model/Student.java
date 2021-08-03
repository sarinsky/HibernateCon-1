package com.trnetwork.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
@Entity
@Table(name = "Student")
public class Student  implements Serializable{
	
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName ="student_sequence",
			allocationSize = 1 )
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence")
	@Column(name = "id_student")
	private Long id;
	/*Is everything that we have need here */
	@Column(
			name = "name",
			nullable = false,
			length = 255)
	private String name;
	@Column(
			name="email",
			nullable = false,
			//columnDefinition ="var",
			unique = true)
	private String email;
	private LocalDate dof;
	
	//@OneToOne
	//@JoinColumn(name="Rol", referencedColumnName = "id")
	private Integer rol;
	@Transient
	private Integer age;
	
	@ManyToMany
	Set<Subject> subjects;
	
	public Student() {
		
	}

	
	public Student(String name, 
			String email, 
			LocalDate dof, 
			Integer rol, 
			Integer age) {

		this.name = name;
		this.email = email;
		this.dof = dof;
		this.rol = rol;
		this.age = age;
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

	public Student(String name, 
			String email, 
			LocalDate dof,
			Integer rol) {
		
		this.name = name;
		this.email = email;
		this.dof = dof;
		this.rol=rol;
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

	/*public Integer getAge() {
		
		return Period.between(this.dof, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}*/
	

	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "Student ["
				+ "id=" + id + 
				", name='" + name + '\''+
				", email='" + email +'\''+ 
				", dof=" + dof + 
				", rol=" + rol + "]";
	}

	
		
	
	
}
