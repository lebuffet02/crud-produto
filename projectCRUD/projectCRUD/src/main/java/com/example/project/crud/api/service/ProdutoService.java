package com.example.project.crud.api.service;

import com.example.project.crud.entity.ProdutoEntity;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    ProdutoEntity criarProduto(ProdutoEntity produtoEntity);

    List<ProdutoEntity> getProdutos();

    Optional<ProdutoEntity> getProdutoId(Long id);

    void atualizaProduto(Long id, ProdutoEntity produtoEntity);

    void produtoIdDeletado(Long id);
}
