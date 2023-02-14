package com.example.pruebamicroservicioscolegio.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnoDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionAlumnoDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionAlumnoDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumno;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.repository.AlumnoRepository;
import com.example.pruebamicroservicioscolegio.ws.repository.SalonRepository;
@Service
public class AlumnoService {
	
	

	@Autowired
	AlumnoRepository alumnoRepository;
	
	public AlumnoDTO consultarSalonId(String nombreAlumno) throws SiecaException {
		try {
			
			Alumno reSalonss= alumnoRepository.findBynombreAlumno(nombreAlumno);
			if (reSalonss != null) {
				 
			AlumnoDTO res=new AlumnoDTO();
			res.setDireccionVivienda(reSalonss.getDireccionVivienda());
			res.setDocumentoAlumno(reSalonss.getDocumentoAlumno());
			res.setFechaNacimineto(reSalonss.getFechaNacimineto());
			res.setIdAlumnos(reSalonss.getIdAlumnos());
			res.setNombreAcudiente(reSalonss.getNombreAcudiente());
			res.setNombreAlumno(reSalonss.getNombreAlumno());
			res.setNumeroContacto(reSalonss.getNumeroContacto());	
			
			return res;
			}
		} catch (Exception e) {
			return null;
			
			//throw new SiecaException("400", e.getMessage());
		}
		
		
		
		return null;
	}
	//BDY
	public RespuestaCreacionAlumnoDTO ingresarAlumno(DatosCreacionAlumnoDTO datosCreacionSalonDTO ) {
		
		Alumno alumno = new Alumno();
		
		alumno.setNombreAcudiente(datosCreacionSalonDTO.getNombreAcudiente());
		alumno.setDocumentoAlumno(datosCreacionSalonDTO.getDocumentoAlumno());
		alumno.setDireccionVivienda(datosCreacionSalonDTO.getDireccionVivienda());
		alumno.setFechaNacimineto(datosCreacionSalonDTO.getFechaNacimineto());
		alumno.setNombreAlumno(datosCreacionSalonDTO.getNombreAlumno());
		alumno.setNumeroContacto(datosCreacionSalonDTO.getNumeroContacto());
		alumno.setSalon(datosCreacionSalonDTO.getIdSalon());
		
		
		alumnoRepository.save(alumno);
		
		RespuestaCreacionSalonDTO respuesta = new RespuestaCreacionSalonDTO();
		
		RespuestaCreacionAlumnoDTO resp = new RespuestaCreacionAlumnoDTO();
		resp.setNombreAcudiente(datosCreacionSalonDTO.getNombreAcudiente());
		resp.setDocumentoAlumno(datosCreacionSalonDTO.getDocumentoAlumno());
		resp.setDireccionVivienda(datosCreacionSalonDTO.getDireccionVivienda());
		resp.setFechaNacimineto(datosCreacionSalonDTO.getFechaNacimineto());
		resp.setNombreAlumno(datosCreacionSalonDTO.getNombreAlumno());
		resp.setNumeroContacto(datosCreacionSalonDTO.getNumeroContacto());
		resp.setIdSalon(datosCreacionSalonDTO.getIdSalon());
		
		return resp;
	}
	
	
	

}
