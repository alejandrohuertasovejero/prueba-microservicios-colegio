package com.example.pruebamicroservicioscolegio.ws.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pruebamicroservicioscolegio.ws.entity.Salon;

public interface SalonRepository extends JpaRepository<Salon, Integer> {

	Salon findBynombreCurso(String nombreCurso);

	@Query(nativeQuery = true, value = "select idSalon,nombreCurso,capacidadAlumnos from tbl_salones where nombreCurso=:nombreCurso")
	Map<String, Object> salonPorNombre(String nombreCurso);

	@Query(nativeQuery = true, value = "SELECT tbl_materias.nombreMateria, tbl_materias.notaFinal, tbl_alumnos.nombreAlumno, tbl_salones.nombreCurso from tbl_salones INNER JOIN tbl_alumnos ON tbl_salones.idSalon=tbl_alumnos.idSalon INNER JOIN tbl_materias ON tbl_materias.idAlumnos= tbl_alumnos.idAlumnos WHERE tbl_alumnos.nombreAlumno=:nombreAlumno")
	List<Map<String, Object>> materiaNombre(String nombreAlumno);

	// @Query(nativeQuery = true, value = "select * from tbl_salones join
	// tbl_alumnos on tbl_salones.idSalon=tbl_alumnos.idSalon join tbl_materias on
	// tbl_materias.idAlumnos=tbl_alumnos.idAlumnos")
	// List< Map<String, Object>> datosColegio();

	@Query(nativeQuery = true, value = "select tbl_salones.idSalon,tbl_salones.nombreCurso,tbl_salones.capacidadAlumnos,tbl_alumnos.idAlumnos,tbl_alumnos.documentoAlumno,tbl_alumnos.nombreAlumno,tbl_alumnos.fechaNacimineto,tbl_alumnos.direccionVivienda,tbl_alumnos.nombreAcudiente,tbl_alumnos.numeroContacto ,tbl_materias.idmateria,tbl_materias.nombreMateria,tbl_materias.notaFinal from tbl_salones join tbl_alumnos on tbl_salones.idSalon=tbl_alumnos.idSalon join tbl_materias on tbl_materias.idAlumnos=tbl_alumnos.idAlumnos")
	List<Map<String, Object>> datosColegio();

	@Query(nativeQuery = true, value = "select * from tbl_salones")
	List<Map<String, Object>> datosSalones();

	@Query(nativeQuery = true, value = "select * from tbl_alumnos")
	List<Map<String, Object>> datosAlumnos();

	@Query(nativeQuery = true, value = "select * from tbl_materias")
	List<Map<String, Object>> datosMateria();

	// @Query(nativeQuery = true, value = "insert tbl_salones()\r\n" + "VALUES
	// (nombreCurso, capacidadAlumnos)")
	// Map<String, Object> salonNuevo(Salon salon);

	
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into tbl_salones ( nombreCurso, capacidadAlumnos ) Values(:salonA,:num)")
	void salonAdd(String salonA, Integer num);


	@Query(nativeQuery = true,value = "select *  from tbl_salones  where tbl_salones.nombreCurso =:nombreSalon")
	List<Map<String,Object >> respuestaSalonAdd(String nombreSalon );
	

}
