package com.example.pruebamicroservicioscolegio.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_materias")
public class Materia {
	
	@Id
	@Column(name = "idmateria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmateria;
	
	
	@Column(name = "nombreMateria")
	private String nombreMateria;
	
	@Column(name = "notaFinal")
	private String notaFinal;
	
	
	@Column(name = "idAlumnos")
	private int idAlumnos;
	
	

	
	
	

	public int getIdAlumnos() {
		return idAlumnos;
	}

	public void setIdAlumnos(int idAlumnos) {
		this.idAlumnos = idAlumnos;
	}

	public int getIdmateria() {
		return idmateria;
	}

	public void setIdmateria(int idmateria) {
		this.idmateria = idmateria;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(String notaFinal) {
		this.notaFinal = notaFinal;
	}

	

}
