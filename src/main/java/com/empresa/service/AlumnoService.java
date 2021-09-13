package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Alumno;

public interface AlumnoService {


	public abstract List<Alumno> listaAlumno();
	public abstract Alumno insertaActualiAlumno(Alumno obj);
	public abstract Optional <Alumno> ontenerPorId(int idAlumno);
	public abstract void eliminarPorid(int idAlumno);
	public abstract List<Alumno> buscaPorDni(String dni);
}
