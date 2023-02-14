package com.example.pruebamicroservicioscolegio.ws.service;

import java.security.PublicKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnoDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriaDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumno;
import com.example.pruebamicroservicioscolegio.ws.entity.Materia;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.repository.AlumnoRepository;
import com.example.pruebamicroservicioscolegio.ws.repository.MateriaRepository;
import com.example.pruebamicroservicioscolegio.ws.repository.SalonRepository;

@Service
public class SalonService {

	@Autowired
	SalonRepository salonRepository;

	@Autowired
	MateriaRepository materiaRepository;

	@Autowired
	AlumnoRepository alumnoRepository;

	public SalonDTO consultarSalon(String nombreSalon) {
		// Salon reSalon= salonRepository.findBynombreCurso(nombreSalon);
		Map<String, Object> reSalon = salonRepository.salonPorNombre(nombreSalon);
		if (reSalon != null) {

			SalonDTO respuestaDto = new SalonDTO();
			System.out.println("esto es lo que esta devolviendo la consulta  " + reSalon);
			respuestaDto.setIdSalon(Integer.parseInt(reSalon.get("idSalon").toString()));
			respuestaDto.setNombreSalon(reSalon.get("nombreCurso").toString());
			respuestaDto.setCantidad(Integer.parseInt(reSalon.get("capacidadAlumnos").toString()));
			return respuestaDto;
		}

		return null;
	}

	public SalonDTO consultarSalonId(Integer idSalon) throws SiecaException {
		try {
			Salon reSalons = salonRepository.getById(idSalon);
			if (reSalons != null) {

				SalonDTO respuestaDto = new SalonDTO();
				respuestaDto.setIdSalon(reSalons.getIdSalon());
				respuestaDto.setNombreSalon(reSalons.getNombreCurso());
				respuestaDto.setCantidad(reSalons.getCapacidadAlumnos());
				return respuestaDto;
			}
		} catch (Exception e) {
			return null;

			// throw new SiecaException("400", e.getMessage());
		}

		return null;
	}

	public SalonDTO ConsultarNotas(String nombreAlumno) {
		try {

			List<Map<String, Object>> respuestaNotasList = salonRepository.materiaNombre(nombreAlumno);

			if (respuestaNotasList != null && !respuestaNotasList.isEmpty()) {

				SalonDTO salonDTO = new SalonDTO();
				AlumnoDTO alumno = new AlumnoDTO();

				List<AlumnoDTO> listaAlumno = new ArrayList<>();
				List<MateriaDTO> listaMateriasDTOs = new ArrayList<>();

				salonDTO.setNombreSalon(respuestaNotasList.get(0).get("nombreCurso") == null ? "Este dato no existe"
						: respuestaNotasList.get(0).get("nombreCurso").toString());

				alumno.setNombreAlumno(respuestaNotasList.get(0).get("nombreAlumno") == null ? "Este dato no existe"
						: respuestaNotasList.get(0).get("nombreAlumno").toString());
				alumno.setNombreAcudiente(
						respuestaNotasList.get(0).get("nombreAcudiente") == null ? "Este dato no existe"
								: respuestaNotasList.get(0).get("nombreAcudiente").toString());

				listaAlumno.add(alumno);

				for (Map<String, Object> map : respuestaNotasList) {

					MateriaDTO materiaDTO = new MateriaDTO();

					materiaDTO.setNombreMateria(map.get("nombreMateria") == null ? "Este dato  no existe"
							: map.get("nombreMateria").toString());
					materiaDTO.setNotaFinal(
							map.get("notaFinal") == null ? "Este dato no exixte " : map.get("notaFinal").toString());
					materiaDTO.setIdmateria(
							map.get("idMateria") == null ? null : Integer.parseInt(map.get("idMateria").toString()));

					listaMateriasDTOs.add(materiaDTO);

				}

				alumno.setMateriaDTOs(listaMateriasDTOs);

				salonDTO.setAlumnos(listaAlumno);

				return salonDTO;
			}

			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		// return null;
	}

	public List<SalonDTO> datosColegio() {
		try {

			List<Map<String, Object>> datosSalones = salonRepository.datosSalones();

			List<Map<String, Object>> datosAlumnos = salonRepository.datosAlumnos();

			List<Map<String, Object>> datosMateria = salonRepository.datosMateria();

			List<SalonDTO> listaSalon = new ArrayList<>();

			for (Map<String, Object> mapDatosSalones : datosSalones) {
				int llaveSalon = Integer.parseInt(mapDatosSalones.get("idSalon").toString());
				SalonDTO salon = new SalonDTO();

				salon.setNombreSalon(mapDatosSalones.get("nombreCurso").toString());
				salon.setIdSalon(Integer.parseInt(mapDatosSalones.get("idSalon").toString()));
				salon.setCantidad(Integer.parseInt(mapDatosSalones.get("capacidadAlumnos").toString()));

				List<AlumnoDTO> listaAlumnos = new ArrayList<>();

				for (Map<String, Object> mapDatosAlumnos : datosAlumnos) {
					int llaveAlumnosSalon = Integer.parseInt(mapDatosAlumnos.get("idSalon").toString());
				

					if (llaveSalon == llaveAlumnosSalon) {
						AlumnoDTO alumno = new AlumnoDTO();
						alumno.setIdAlumnos(Integer.parseInt(mapDatosAlumnos.get("idAlumnos").toString()));
						alumno.setNombreAlumno(mapDatosAlumnos.get("nombreAlumno").toString());
						alumno.setDocumentoAlumno(mapDatosAlumnos.get("nombreAlumno").toString());
						alumno.setFechaNacimineto(Date.valueOf(mapDatosAlumnos.get("fechaNacimineto").toString()));
						alumno.setDireccionVivienda(mapDatosAlumnos.get("direccionVivienda").toString());
						alumno.setNombreAcudiente(mapDatosAlumnos.get("nombreAcudiente").toString());
						alumno.setNumeroContacto(mapDatosAlumnos.get("numeroContacto").toString());

						List<MateriaDTO> listaMaterias = new ArrayList<>();
						for (Map<String, Object> mapDatosMateria : datosMateria) {

							int llaveMateria = Integer.parseInt(mapDatosMateria.get("idAlumnos").toString());
							if (llaveMateria == alumno.getIdAlumnos()) {

								MateriaDTO materia = new MateriaDTO();

								materia.setNombreMateria(mapDatosMateria.get("nombreMateria").toString());
								materia.setIdmateria(Integer.parseInt(mapDatosMateria.get("idmateria").toString()));
								materia.setNotaFinal(mapDatosMateria.get("notaFinal").toString());

								listaMaterias.add(materia);
							}

						}
						alumno.setMateriaDTOs(listaMaterias);
						listaAlumnos.add(alumno);

					}

				}
				salon.setAlumnos(listaAlumnos);
				listaSalon.add(salon);
			}

			return listaSalon;

		} catch (Exception e) {

			return null;

		}

	}

	public List<SalonDTO> datosColegio2() {
		try {
		
			List<Salon>listSalones= salonRepository.findAll();
			List<Alumno>listAlumnos=  alumnoRepository.findAll();
			List<Materia> listMaterias= materiaRepository.findAll();
			
			
			List<SalonDTO> listaSalon = new ArrayList<>();
			
			for (Salon     mapSalon1 : listSalones) {
				int llaveSalon = (mapSalon1.getIdSalon());
				SalonDTO salon = new SalonDTO();
				
				salon.setNombreSalon(mapSalon1.getNombreCurso());
				salon.setIdSalon( mapSalon1.getIdSalon());
				salon.setCantidad( mapSalon1.getCapacidadAlumnos());
				
				List<AlumnoDTO> listaAlumnos = new ArrayList<>();

				for (Alumno alumnoss : listAlumnos) {
					int llaveAlumnosSalon = (alumnoss.getSalon());
					
					if (llaveAlumnosSalon == llaveSalon) {
						AlumnoDTO alumno = new AlumnoDTO();
						alumno.setIdAlumnos(alumnoss.getIdAlumnos());
						alumno.setNombreAlumno(alumnoss.getNombreAlumno());
						alumno.setDocumentoAlumno(alumnoss.getNombreAlumno());
						alumno.setFechaNacimineto(alumnoss.getFechaNacimineto());
						alumno.setDireccionVivienda(alumnoss.getDireccionVivienda());
						alumno.setNombreAcudiente(alumnoss.getNombreAcudiente());
						alumno.setNumeroContacto(alumnoss.getNumeroContacto());
						alumno.setIdSalon(alumnoss.getIdAlumnos());
						
						List<MateriaDTO> listaMateria = new ArrayList<>();
						
						for (Materia materiass : listMaterias) {

							int llaveMateria = (materiass.getIdAlumnos());
							if (llaveMateria == alumno.getIdAlumnos()) {

								MateriaDTO materia = new MateriaDTO();

								materia.setNombreMateria(materiass.getNombreMateria());
								materia.setIdmateria(materiass.getIdmateria());
								materia.setNotaFinal(materiass.getNotaFinal() == null ?"  ":materiass.getNotaFinal());
								materia.setIdAlumnos(materiass.getIdAlumnos());
							
								listaMateria.add(materia);
							}

						}
						alumno.setMateriaDTOs(listaMateria);
						listaAlumnos.add(alumno);

					}

				}
				salon.setAlumnos(listaAlumnos);
				listaSalon.add(salon);
			}

			return listaSalon;

		} catch (Exception e) {

			return null;

		}
	}
	
	//  Body 
	
	public RespuestaCreacionSalonDTO ingresarSalon(DatosCreacionSalonDTO datosCreacionSalonDTO ) {
		Salon salon = new Salon();
		salon.setNombreCurso(datosCreacionSalonDTO.getNombreCurso());
		salon.setCapacidadAlumnos(datosCreacionSalonDTO.getCapacidadAlumnos());
		
		salonRepository.save(salon);
		
		RespuestaCreacionSalonDTO respuesta = new RespuestaCreacionSalonDTO();
		respuesta.setIdSalon(salon.getIdSalon());
		respuesta.setNombreSalon(salon.getNombreCurso());
		respuesta.setCantidad(salon.getCapacidadAlumnos());
		return respuesta;
		
		}
	//xxxxxxxx
	public RespuestaCreacionSalonDTO ingresarSalonn(DatosCreacionSalonDTO datosCreacionSalonDTO ) {
		
		
		Salon salon = new Salon();
		salon.setNombreCurso(datosCreacionSalonDTO.getNombreCurso());
		salon.setCapacidadAlumnos(datosCreacionSalonDTO.getCapacidadAlumnos());
		 
		salonRepository.save(salon);
		
		RespuestaCreacionSalonDTO respuesta = new RespuestaCreacionSalonDTO();
		respuesta.setIdSalon(salon.getIdSalon());
		respuesta.setNombreSalon(salon.getNombreCurso());
		respuesta.setCantidad(salon.getCapacidadAlumnos());
		return respuesta;
		
		
	}
	
	

}
