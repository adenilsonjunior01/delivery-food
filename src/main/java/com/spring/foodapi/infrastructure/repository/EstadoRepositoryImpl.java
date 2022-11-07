package com.spring.foodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.spring.foodapi.domain.model.Estado;
import com.spring.foodapi.domain.respository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Estado> listar() {
		return entityManager.createQuery("from Estado", Estado.class)
				.getResultList();
	}

	@Override
	public Estado buscar(Long id) {
		return entityManager.find(Estado.class, id);
	}

	@Transactional
	@Override
	public Estado salvar(Estado estado) {
		return entityManager.merge(estado);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		Estado estado = buscar(id);
		
		if (estado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		entityManager.remove(estado);		
	}

	
}
