package com.example.pruebamicroservicioscolegio.ws.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.service.SalonService;

@RestController
public class SalonControllerImpl implements SalonController {

	@Autowired
	SalonService salonService;

	@Override
	public ResponseEntity<ResponseDTO> consultarsalonnombre(String nombreAlumno) throws SiecaException {
		// TODO Auto-generated method stub
		
		if(nombreAlumno !=null && !nombreAlumno.isEmpty()) {
		ResponseDTO responseDTO = new ResponseDTO();
		SalonDTO respuesta = salonService.ConsultarNotas(nombreAlumno);

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

		}else {
			ResponseDTO responseDTO = new ResponseDTO();
			List<SalonDTO> respuesta = salonService.datosColegio();

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

	@Override
	public ResponseEntity<ResponseDTO> consultarNombreNota(Integer idSalon) throws SiecaException {
		ResponseDTO responseDT = new ResponseDTO();
		SalonDTO respuesta = salonService.consultarSalonId(idSalon);

		if (respuesta != null) {
			responseDT.setResponse(respuesta);
			responseDT.getServiceException().setMessageId("200");
			responseDT.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDT, HttpStatus.OK);
		} else {
			System.out.println("dentro al error");
			responseDT.setResponse(null);
			responseDT.getServiceException().setMessageId("400");
			responseDT.getServiceException().setText("Fallo en la operación.");
			responseDT.getServiceException().setVariables("No existe información ingresada.");
			return new ResponseEntity(responseDT, HttpStatus.BAD_REQUEST);
		}

	}

	

	@Override
	public ResponseEntity<ResponseDTO> datosColegio2() throws SiecaException {
		ResponseDTO responseDT = new ResponseDTO();
		List<SalonDTO> respuesta = salonService.datosColegio2();

		if (respuesta != null) {
			responseDT.setResponse(respuesta);
			responseDT.getServiceException().setMessageId("200");
			responseDT.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDT, HttpStatus.OK);
		} else {
			System.out.println("dentro al error");
			responseDT.setResponse(null);
			responseDT.getServiceException().setMessageId("400");
			responseDT.getServiceException().setText("Fallo en la operación.");
			responseDT.getServiceException().setVariables("No existe información ingresada.");
			return new ResponseEntity(responseDT, HttpStatus.BAD_REQUEST);
		}
		
		
		
		
	}
	
	
	// Body 

	@Override
	public ResponseEntity<ResponseDTO> ingresarColegio(DatosCreacionSalonDTO datosIngresados) throws SiecaException {
		
		
		RespuestaCreacionSalonDTO respuesta = salonService.ingresarSalon(datosIngresados);
		ResponseDTO responseDT = new ResponseDTO();
		

		if (respuesta != null) {
			responseDT.setResponse(respuesta);
			responseDT.getServiceException().setMessageId("200");
			responseDT.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDT, HttpStatus.OK);
		} else {
			System.out.println("dentro al error");
			responseDT.setResponse(null);
			responseDT.getServiceException().setMessageId("400");
			responseDT.getServiceException().setText("Fallo en la operación.");
			responseDT.getServiceException().setVariables("No existe información ingresada.");
			return new ResponseEntity(responseDT, HttpStatus.BAD_REQUEST);
		}
		
		
		
	}

	@Override
	public ResponseEntity<ResponseDTO> ingresarColegios(DatosCreacionSalonDTO datosIngresados) throws SiecaException {
		RespuestaCreacionSalonDTO respuesta = salonService.ingresarSalonn(datosIngresados);
		ResponseDTO responseDT = new ResponseDTO();

		if (respuesta != null) {
			responseDT.setResponse(respuesta);
			responseDT.getServiceException().setMessageId("200");
			responseDT.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDT, HttpStatus.OK);
		} else {
			System.out.println("dentro al error");
			responseDT.setResponse(null);
			responseDT.getServiceException().setMessageId("400");
			responseDT.getServiceException().setText("Fallo en la operación.");
			responseDT.getServiceException().setVariables("No existe información ingresada.");
			return new ResponseEntity(responseDT, HttpStatus.BAD_REQUEST);
		}
	}

	
}
