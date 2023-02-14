package com.example.pruebamicroservicioscolegio.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnoDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriaDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumno;
import com.example.pruebamicroservicioscolegio.ws.entity.Materia;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.repository.MateriaRepository;
@Service
public class MateriaService {
	
	
	@Autowired
	MateriaRepository materiaRepository;
	
	
	
	
	public MateriaDTO consultarMaterias(String nombreMateria) throws SiecaException {
		try {
			
			Materia reSalonss= materiaRepository.findBynombreMateria(nombreMateria);
			if (reSalonss != null) {
				 
			MateriaDTO res=new MateriaDTO();
			res.setIdmateria(reSalonss.getIdmateria());
			res.setNombreMateria(reSalonss.getNombreMateria());
			res.setNotaFinal(reSalonss.getNotaFinal());
			
			
			return res;
			}
		} catch (Exception e) {
			return null;
			
			//throw new SiecaException("400", e.getMessage());
		}
		
		
		
		return null;
	}

}
