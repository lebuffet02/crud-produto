package com.example.project.crud.api.service;

import com.example.project.crud.api.entity.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    ProdutoEntity criarProduto(ProdutoEntity produtoEntity);

    Page<ProdutoEntity> getProdutos(Pageable pageable);

    Optional<ProdutoEntity> getProdutoId(Long id);

    void atualizaProduto(Long id, ProdutoEntity produtoEntity);

    void produtoIdDeletado(Long id);
}
