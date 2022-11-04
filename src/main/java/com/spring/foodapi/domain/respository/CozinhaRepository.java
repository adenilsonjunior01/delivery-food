package com.spring.foodapi.domain.respository;

import java.util.List;

import com.spring.foodapi.domain.model.Cozinha;

public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long id);
}
