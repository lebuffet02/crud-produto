package com.example.project.crud.api.core;

import com.example.project.crud.api.entity.ProdutoEntity;
import com.example.project.crud.api.record.ProdutoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Optional<ProdutoDto> criarProduto(ProdutoDto produtoDto);

    Page<ProdutoDto> getProdutos(Pageable pageable);

    Optional<ProdutoDto> getProdutoId(Long id);

    Optional<ProdutoDto> atualizarProduto(Long id, ProdutoDto produtoEntity);

    void produtoIdDeletado(Long id);

    void deletarTodos();
}
