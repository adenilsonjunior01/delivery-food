package com.spring.foodapi.domain.respository;

import java.util.List;

import com.spring.foodapi.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar(Long id);
	Cidade salvar(Cidade cidade);
	void remover(Long id);
}
