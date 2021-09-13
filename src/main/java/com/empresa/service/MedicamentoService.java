package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	public abstract List<Medicamento> listaMedicamento();
	public abstract Medicamento registrarMedicamento( Medicamento obj);
	public abstract Optional<Medicamento> obtener(int idMedicamento);
	public abstract List<Medicamento> listtaNombrelike(String nombre);
	public abstract List<Medicamento> buscarstock(int stock);
}
