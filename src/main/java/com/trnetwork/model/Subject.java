package com.trnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subject {
	
	@Id
	@SequenceGenerator(
			name="subject_sequence",
			sequenceName="subject_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "subject_sequence")
	private Long id;
	private String name;
	
	public Subject() {
		
	}
	public Subject(Long id, String name) {

		this.id = id;
		this.name = name;
	}
	
	public Subject(String name) {

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
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
