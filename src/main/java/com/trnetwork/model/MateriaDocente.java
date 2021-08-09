package com.trnetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MateriaDocente")
public class MateriaDocente {
	
	@Id 
	@SequenceGenerator(
		name="md_sequence",
		sequenceName = "md_sequence",
		allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "md_sequence")
	@Column(name = "md_id")
	private Long Id;
	private String periodo;
	private String calif;
	private Integer cve_doc;
	private Integer id_dm;
	public MateriaDocente() {
		 
	 }
	public MateriaDocente(Long id, String periodo, String calif, Integer cve_doc, Integer id_dm) {

		Id = id;
		this.periodo = periodo;
		this.calif = calif;
		this.cve_doc = cve_doc;
		this.id_dm = id_dm;
	}
	public MateriaDocente(String periodo, String calif, Integer cve_doc, Integer id_dm) {

		this.periodo = periodo;
		this.calif = calif;
		this.cve_doc = cve_doc;
		this.id_dm = id_dm;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getCalif() {
		return calif;
	}
	public void setCalif(String calif) {
		this.calif = calif;
	}
	public Integer getCve_doc() {
		return cve_doc;
	}
	public void setCve_doc(Integer cve_doc) {
		this.cve_doc = cve_doc;
	}
	public Integer getId_dm() {
		return id_dm;
	}
	public void setId_dm(Integer id_dm) {
		this.id_dm = id_dm;
	}
	@Override
	public String toString() {
		return "MateriaDocente [Id=" + Id + ", periodo=" + periodo + ", calif=" + calif + ", cve_doc=" + cve_doc
				+ ", id_dm=" + id_dm + "]";
	}
	
	
	
	
	

}
