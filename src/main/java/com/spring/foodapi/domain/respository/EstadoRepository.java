package com.spring.foodapi.domain.respository;

import java.util.List;

import com.spring.foodapi.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Estado estado);
}
