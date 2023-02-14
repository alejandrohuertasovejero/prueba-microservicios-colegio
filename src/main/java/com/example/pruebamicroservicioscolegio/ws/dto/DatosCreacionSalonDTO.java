package com.example.pruebamicroservicioscolegio.ws.dto;

import javax.management.loading.PrivateClassLoader;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DatosCreacionSalonDTO {

	// nombre de la bd
	@NotBlank(message = "no  puede ser nulo nombreCurso")
	private String nombreCurso;
	private Integer capacidadAlumnos;

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public Integer getCapacidadAlumnos() {
		return capacidadAlumnos;
	}

	public void setCapacidadAlumnos(Integer capacidadAlumnos) {
		this.capacidadAlumnos = capacidadAlumnos;
	}

}
