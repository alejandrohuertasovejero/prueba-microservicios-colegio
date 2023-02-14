package com.example.pruebamicroservicioscolegio.ws.ui.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;

@RequestMapping("/nttdata/service/v1/prueba-microcolegio1")
public interface MateriaController {

	
	
	@GetMapping("/colegioMaterias")
	public ResponseEntity<ResponseDTO> consultarCarpetaComercialGenerica(
			@RequestParam(required = true) String nombreMateria) throws SiecaException;
	
	
}
