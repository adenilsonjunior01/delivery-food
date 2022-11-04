package com.spring.foodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.spring.foodapi.domain.model.Permissao;
import com.spring.foodapi.domain.respository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Permissao> listar() {
		return entityManager.createQuery("from Permissao", Permissao.class)
				.getResultList();
	}

	@Override
	public Permissao buscar(Long id) {
		return entityManager.find(Permissao.class, id);
	}

	@Transactional
	@Override
	public Permissao salvar(Permissao permissao) {
		return entityManager.merge(permissao);
	}

	@Transactional
	@Override
	public void remover(Permissao permissao) {
		permissao = buscar(permissao.getId());
		entityManager.remove(permissao);		
	}
}
