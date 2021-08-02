package com.trnetwork.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="ScheduleSubject")
public class ScheduleSubject  implements Serializable{

	// id, horario.date, noControlAl, cve_materia 
	
	
	@Id
	@SequenceGenerator(
			name = "scheduleSubject",
			sequenceName ="scheduleSubject",
			allocationSize = 1 )
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "scheduleSubject")
	private Long id;
	@Column(name = "schedule")
	//@Temporal(TemporalType.TIME) //TemporalType.TIMESTAMP
	//@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate schedule;
	//private Integer
	
	@ManyToOne(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,
			optional = false)
	@JoinColumn(name = "id", 
	referencedColumnName = "id", 
	insertable = false, 
	updatable = false)//insert="false" update="false"
	private Subject subject;
	
	//@ManyToOne(fetch = )
	@ManyToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			optional = false
			 )
	@JoinColumn(name = "id", referencedColumnName = "id",	 
			insertable = false, 
			updatable = false)
	private Student student;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getSchedule() {
		return schedule;
	}
	public void setSchedule(LocalDate schedule) {
		this.schedule = schedule;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
