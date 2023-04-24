package com.example.project.crud.api.service;

import com.example.project.crud.api.db.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto criarProduto(Produto produto);

    List<Produto> getProdutos();

    Optional<Produto> getProdutoId(Long id);

    void atualizaProduto(Long id, Produto produto);

    void produtoIdDeletado(Long id);
}
