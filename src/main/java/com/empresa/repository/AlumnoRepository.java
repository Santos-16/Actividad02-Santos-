package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	public List<Alumno> findByDni(String dni);
	//@Query("select x from Alumno x where x.dni = :param_dni")

		//public List<Alumno> buscaPorDni(@Param("param_dni") String dni);
}
