package com.trnetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "horarioMateria")
public class HorarioMateria {
	@Id
	@SequenceGenerator(
			name = "hm_sequence",
			sequenceName ="hm_sequence",
			allocationSize = 1 )
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "hm_sequence")
	@Column(name = "hm_id")
	private Long id;
	
	
	@Column(name = "horario", nullable = false,
			length = 255)
	private String horario;
	
	@Column(name="id", nullable = false,
			length = 255)
	private Integer noControl;
	
	@Column(name = "subject_id", nullable = false,
			length = 255)
	private Integer cve_mat;
	
	
	public HorarioMateria() {
		
	}
	public HorarioMateria(Long id, String horario, Integer noControl, Integer cve_mat) {

		this.id = id;
		this.horario = horario;
		this.noControl = noControl;
		this.cve_mat = cve_mat;
	}
	public HorarioMateria(String horario, Integer noControl, Integer cve_mat) {
	
		this.horario = horario;
		this.noControl = noControl;
		this.cve_mat = cve_mat;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Integer getNoControl() {
		return noControl;
	}
	public void setNoControl(Integer noControl) {
		this.noControl = noControl;
	}
	public Integer getCve_mat() {
		return cve_mat;
	}
	public void setCve_mat(Integer cve_mat) {
		this.cve_mat = cve_mat;
	}
	@Override
	public String toString() {
		return "HorarioMateria [id=" + id + ", horario=" + horario + ", noControl=" + noControl + ", cve_mat=" + cve_mat
				+ "]";
	}
	
	
	
	
	
}
