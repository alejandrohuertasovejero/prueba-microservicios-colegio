package com.example.pruebamicroservicioscolegio.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.pruebamicroservicioscolegio.ws.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

	
	Materia findBynombreMateria(String nombreMateria);
	
}
