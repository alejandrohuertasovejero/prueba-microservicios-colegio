package com.example.pruebamicroservicioscolegio.ws.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_alumnos")
public class Alumno {
	
	

	@Id
	@Column(name = "idAlumnos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlumnos;
	
	@Column(name = "documentoAlumno")
	private String documentoAlumno;
	
	@Column(name = "nombreAlumno")
	private String nombreAlumno;
	
	@Column(name = "fechaNacimineto")
	private Date fechaNacimineto;
	
	@Column(name = "direccionVivienda")
	private String direccionVivienda;
	
	@Column(name = "nombreAcudiente")
	private String nombreAcudiente;
	
	@Column(name = "numeroContacto")
	private String numeroContacto;
	

	@Column(name = "idSalon")
	private int salon;

	public int getIdAlumnos() {
		return idAlumnos;
	}

	public void setIdAlumnos(int idAlumnos) {
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

	public int getSalon() {
		return salon;
	}

	public void setSalon(int salon) {
		this.salon = salon;
	}

	
	
	
	
	
	
	

}
