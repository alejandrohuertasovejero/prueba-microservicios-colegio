package com.example.pruebamicroservicioscolegio.ws.ui.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;

@RequestMapping("/nttdata/service/v1/prueba-microcolegio1")
public interface AlumnoController {
	
	

	@GetMapping("/colegioAlumnos")
	public ResponseEntity<ResponseDTO> consultarCarpetaComercialGenerica(
			@RequestParam(required = true) String nombreAlumno) throws SiecaException;

	
	@PostMapping("/alumno")
	public ResponseEntity<ResponseDTO> ingresarColegio(
			@RequestBody DatosCreacionSalonDTO datosIngresados)throws SiecaException;
	
	
}
