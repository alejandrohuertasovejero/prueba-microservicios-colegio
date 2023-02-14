package com.example.pruebamicroservicioscolegio.ws.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.example.pruebamicroservicioscolegio.ws.dto.MateriaDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.service.MateriaService;

@RestController
public class MateriaControllerImpl implements MateriaController {

	@Autowired
	MateriaService materiaService;
	
	
	@Override
	public ResponseEntity<ResponseDTO> consultarCarpetaComercialGenerica(String nombreMateria) throws SiecaException {
		ResponseDTO responseDTO = new ResponseDTO();
		MateriaDTO respuesta = materiaService.consultarMaterias(nombreMateria);

		if (respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText("Fallo en la operación.");
			responseDTO.getServiceException().setVariables("No existe información ingresada.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}

		
	}
	}


