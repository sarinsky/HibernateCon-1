package com.trnetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@SequenceGenerator(name = "user_sequence",
			sequenceName ="user_sequence",
			allocationSize = 1 )
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence")
	private Long id;
	@Column(
			name="email",
			nullable = false,
			length = 255,
			//columnDefinition ="var",
			unique = true)
	private String email;
	@Column(name = "pwd",
			nullable = false,
			length = 255,
			unique = true)
		
	private String pdw;
	public User() {
		
	}
	public User(String email, String pdw) {
		this.email = email;
		this.pdw = pdw;
	}
	public User(Long id, String email, String pdw) {

		this.id = id;
		this.email = email;
		this.pdw = pdw;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPdw() {
		return pdw;
	}
	public void setPdw(String pdw) {
		this.pdw = pdw;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pdw=" + pdw + "]";
	}
	
	
	
	
	
	
	
	
}
