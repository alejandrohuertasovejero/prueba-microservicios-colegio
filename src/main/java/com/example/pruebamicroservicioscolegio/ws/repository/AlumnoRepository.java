package com.example.pruebamicroservicioscolegio.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pruebamicroservicioscolegio.ws.entity.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	Alumno findBynombreAlumno(String nombreAlumno);
	
	
	
}
