package com.trnetwork.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="Docente") 
public class Docente {
	
	@Id 
	@SequenceGenerator(
		name="docent_sequence",
		sequenceName = "docent_sequence",
		allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "docent_sequence")
	
	private Long Id;
	private String name;
	private String email;
	private LocalDate dob;
	
	@Transient
	private Integer age;
	

	
	public Docente() {
		
	}

	public Docente(Long id, 
			String name, 
			String email, 
			LocalDate dob) {
		this.Id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;

	}

	public Docente(String name, String email, LocalDate dob) {

		this.name = name;
		this.email = email;
		this.dob = dob;

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/*public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}
*/
	@Override
	public String toString() {
		return "Docente [Id=" + Id + 
				", name='" + name + '\''+
				", email='" + email + '\''+
				", dob=" + dob +  "]";
	}
	
	
	
	
	
	
}
