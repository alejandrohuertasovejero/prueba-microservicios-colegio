package com.example.pruebamicroservicioscolegio.ws.dto;

import java.util.List;

public class MateriaDTO {
	
	//idmateria , nombreMateria, notaFinal,idAlumnos
	private Integer idmateria;
	private String nombreMateria;
	private String notaFinal;
	private int idAlumnos;
	
	
	
	public int getIdAlumnos() {
		return idAlumnos;
	}
	public void setIdAlumnos(int idAlumnos) {
		this.idAlumnos = idAlumnos;
	}
	public Integer getIdmateria() {
		return idmateria;
	}
	public void setIdmateria(Integer idmateria) {
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
