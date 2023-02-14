package com.example.pruebamicroservicioscolegio.ws.dto;

import java.sql.Date;
import java.util.List;

import com.example.pruebamicroservicioscolegio.ws.entity.Salon;

public class AlumnoDTO {

	//idAlumnos documentoAlumno  nombreAlumno fechaNacimineto 
	//direccionVivienda  nombreAcudiente  numeroContacto idSalon
	
	
	private Integer idAlumnos;
	private String documentoAlumno;
	private String nombreAlumno;
	private  Date fechaNacimineto;
	private  String direccionVivienda;
	private String nombreAcudiente;
	private  String numeroContacto;
	private Integer idSalon;
	private List<MateriaDTO> materia;
	
	
	
	
	public Integer getIdSalon() {
		return idSalon;
	}
	public void setIdSalon(Integer idSalon) {
		this.idSalon = idSalon;
	}
	
	public Integer getIdAlumnos() {
		return idAlumnos;
	}
	public void setIdAlumnos(Integer idAlumnos) {
		this.idAlumnos = idAlumnos;
	}
	public String getDocumentoAlumno() {
		return documentoAlumno;
	}
	public void setDocumentoAlumno(String documentoAlumno) {
		this.documentoAlumno = documentoAlumno;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	
	
	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}
	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}
	public String getDireccionVivienda() {
		return direccionVivienda;
	}
	public void setDireccionVivienda(String direccionVivienda) {
		this.direccionVivienda = direccionVivienda;
	}
	public String getNombreAcudiente() {
		return nombreAcudiente;
	}
	public void setNombreAcudiente(String nombreAcudiente) {
		this.nombreAcudiente = nombreAcudiente;
	}
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	
	
	public List<MateriaDTO> getMateria() {
		return materia;
	}
	public void setMateriaDTOs(List<MateriaDTO> materia) {
		this.materia = materia;
	}
	
	
	
	
	
	
}
