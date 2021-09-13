package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {
	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listarMedicamento(){
		List<Medicamento> lista=service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> registarMedicamento(@RequestBody Medicamento obj){
		if(obj == null) {
			return ResponseEntity.noContent().build();			
		}
		else {
			obj.setIdMedicamento(0);
			Medicamento objsalida=service.registrarMedicamento(obj);
			return ResponseEntity.ok(objsalida);
		}
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Medicamento> actualizarMedicamento(@RequestBody Medicamento obj){
		if(obj==null) {
			return ResponseEntity.noContent().build();
		}else {
			Optional<Medicamento> optioMedicamento =service.obtener(obj.getIdMedicamento());
		if(optioMedicamento.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			Medicamento objSalida=service.registrarMedicamento(obj);
			return ResponseEntity.ok(objSalida);
		}
		}	}
	
	@GetMapping("/id/{paramIdMed}")

	@ResponseBody

	public ResponseEntity<Medicamento> buscaPorId(@PathVariable("paramIdMed") int idMedicamento){

		Optional<Medicamento> optAlumno = service.obtener(idMedicamento);

		if (optAlumno.isPresent()) {

			return ResponseEntity.ok(optAlumno.get());

		}else {

			return ResponseEntity.badRequest().build();

		}

	}
	
	@GetMapping("/nombre/{paramNombre}")

	@ResponseBody

	public ResponseEntity<List<Medicamento>> buscaPorNonbre(@PathVariable("paramNombre") String nombre){

		List<Medicamento> lista = service.listtaNombrelike("%"+nombre+"%");

		if (CollectionUtils.isEmpty(lista)) {

			return ResponseEntity.badRequest().build();

		}else {

			return ResponseEntity.ok(lista);

		}

	}
	
	@GetMapping("/stock/{paramStock}")

	@ResponseBody

	public ResponseEntity<List<Medicamento>> buscaPorstock(@PathVariable("paramStock") int stock){
		List<Medicamento> LISTA =service.buscarstock(stock);
		if (CollectionUtils.isEmpty(LISTA)) {

			return ResponseEntity.badRequest().build();

		}else {

		return ResponseEntity.ok(LISTA);
		}
			

		}

	
	
	
	
	
	
	
}
