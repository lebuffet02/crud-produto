package com.example.project.crud.api.service;

import com.example.project.crud.api.db.entity.ProdutoEntity;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    ProdutoEntity criarProduto(ProdutoEntity produtoEntity);

    List<ProdutoEntity> getProdutos();

    Optional<ProdutoEntity> getProdutoId(String id);

    void atualizaProduto(String id, ProdutoEntity produtoEntity);

    void produtoIdDeletado(String id);
}
