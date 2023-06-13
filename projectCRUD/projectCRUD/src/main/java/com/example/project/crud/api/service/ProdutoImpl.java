package com.example.project.crud.api.service;

import com.example.project.crud.api.exceptions.ProductErrorException;
import com.example.project.crud.api.db.entity.ProdutoEntity;
import com.example.project.crud.api.db.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    @Override
    public ProdutoEntity criarProduto(ProdutoEntity produtoEntity) {
        try {
            return produtoRepository.save(produtoEntity);
        } catch (ProductErrorException e) {
            throw new ProductErrorException("erro ao criar o produto", e);
        }
    }

    @Override
    public List<ProdutoEntity> getProdutos() {
        try {
            return produtoRepository.findAll();
        } catch (ProductErrorException e) {
            throw new ProductErrorException("erro ao listar os produtos", e);
        }
    }

    @Override
    public Optional<ProdutoEntity> getProdutoId(String id) {
        try {
            return produtoRepository.findById(id);
        } catch (ProductErrorException e) {
            throw new ProductErrorException("erro ao pegar o produto", e);
        }
    }

    @Override
    public void atualizaProduto(String id, ProdutoEntity produtoEntity) {
        try {
            if (produtoRepository.existsById(id)) {
                produtoRepository.save(produtoEntity);
            }
        } catch (ProductErrorException e) {
            throw new ProductErrorException("erro ao atualizar o produto", e);
        }
    }

    @Override
    public void produtoIdDeletado(String id) {
        try {
            if (produtoRepository.existsById(id)) {
                produtoRepository.deleteById(id);
            }
        } catch (ProductErrorException e) {
            throw new ProductErrorException("erro ao deletar o produto", e);
        }
    }
}
