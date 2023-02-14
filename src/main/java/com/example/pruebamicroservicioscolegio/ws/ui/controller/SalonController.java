package com.example.pruebamicroservicioscolegio.ws.ui.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;

@RequestMapping("/nttdata/service/v1/prueba-microcolegio1")
public interface SalonController {

	@GetMapping("/colegioNombres")
	public ResponseEntity<ResponseDTO> consultarsalonnombre(@RequestParam(required = false) String nombreAlumno)
			throws SiecaException;

	@GetMapping("/colegioNombress")
	public ResponseEntity<ResponseDTO> consultarNombreNota(@RequestParam(required = true) Integer idSalon)
			throws SiecaException;

	@GetMapping("/colegio")
	public ResponseEntity<ResponseDTO> datosColegio2()
			throws SiecaException;

	
	
	// BDY
	
	@PostMapping("/creacionColegio")
	public ResponseEntity<ResponseDTO> ingresarColegio(
			@RequestBody DatosCreacionSalonDTO datosIngresados)throws SiecaException;
	
	
	//______________
	
	
	@PostMapping("/prueba")
	public ResponseEntity<ResponseDTO> ingresarColegios(
			@RequestBody @Valid DatosCreacionSalonDTO datosIngresados)throws SiecaException;
	
}
