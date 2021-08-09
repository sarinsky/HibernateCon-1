package com.trnetwork.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject implements Serializable{
	
	@Id
	@SequenceGenerator(
			name="subject_sequence",
			sequenceName="subject_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "subject_sequence")
	@Column(name = "subject_id")
	private Long id;
	private String name;
	@Column(name = "ranking")
	private String ranking;

//<<<<<<< HEAD
	//@ManyToMany
//=======
	
//>>>>>>> a0c3de74512933b8ccda6fa240020455474248a0
	@ManyToMany(mappedBy = "subjects")
	Set<Student> students;
	
	public Subject() {
		
	}
	public Subject(Long id, String name,String ranking) {

		this.id = id;
		this.name = name;
		this.ranking=ranking;
	}
	
	public Subject(String name, String ranking) {

		this.name = name;
		this.ranking=ranking;
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
	
	
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", ranking=" + ranking + ", students=" + students + "]";
	}
	
	
	
	
	
}
