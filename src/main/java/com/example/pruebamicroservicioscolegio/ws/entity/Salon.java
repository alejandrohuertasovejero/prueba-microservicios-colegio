package com.example.pruebamicroservicioscolegio.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "tbl_salones")

public class Salon {

	@Id
	@Column(name = "idSalon")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSalon;

	@Column(name = "nombreCurso")
	
	private String nombreCurso;

	@Column(name = "capacidadAlumnos")

	private int capacidadAlumnos;

	public int getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public int getCapacidadAlumnos() {
		return capacidadAlumnos;
	}

	public void setCapacidadAlumnos(int capacidadAlumnos) {
		this.capacidadAlumnos = capacidadAlumnos;
	}

}
