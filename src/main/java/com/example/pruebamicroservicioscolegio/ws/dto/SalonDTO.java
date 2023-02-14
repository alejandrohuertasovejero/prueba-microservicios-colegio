package com.example.pruebamicroservicioscolegio.ws.dto;

import java.util.List;

public class SalonDTO {
	
	private Integer idSalon;
	
	private String nombreSalon;
	private Integer cantidad;
	private List<AlumnoDTO> alumnos;
	
	
	
	
	public List<AlumnoDTO> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<AlumnoDTO> alumnos) {
		this.alumnos = alumnos;
	}
	public Integer getIdSalon() {
		return idSalon;
	}
	public void setIdSalon(Integer idSalon) {
		this.idSalon = idSalon;
	}
	public String getNombreSalon() {
		return nombreSalon;
	}
	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
	

}
