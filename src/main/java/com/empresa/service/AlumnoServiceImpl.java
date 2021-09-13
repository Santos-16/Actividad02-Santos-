package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository repository;
	

	@Override
	public List<Alumno> listaAlumno() {
		return repository.findAll();
	}


	@Override
	public Alumno insertaActualiAlumno(Alumno obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}


	@Override
	public Optional<Alumno> ontenerPorId(int idAlumno) {
		// TODO Auto-generated method stub
		return repository.findById(idAlumno);
	}


	@Override
	public void eliminarPorid(int idAlumno) {
		// TODO Auto-generated method stub
		 repository.deleteById(idAlumno);
		
	}


	@Override
	public List<Alumno> buscaPorDni(String dni) {
		// TODO Auto-generated method stub
		return repository.findByDni(dni);
	}


	



	
	

}
