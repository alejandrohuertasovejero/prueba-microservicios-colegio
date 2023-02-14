package com.example.pruebamicroservicioscolegio.ws.dto;

import javax.management.loading.PrivateClassLoader;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DatosCreacionSalonDTO {

	// nombre de la bd
	//@Size(min = 3,max = 12,message = "este campo admite min 3, max 12")
	@NotBlank(message = "no  puede ser nulo nombreCurso")
	private String nombreCurso;
	@NotNull(message = "no  puede ser nulo capacidadAlumnos")
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
