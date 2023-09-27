package com.example.project.crud.api.service;

import com.example.project.crud.api.exceptions.ProdutoException;
import com.example.project.crud.entity.ProdutoEntity;
import com.example.project.crud.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    @Override
    public ProdutoEntity criarProduto(ProdutoEntity produtoEntity) {
        try {
            return produtoRepository.save(produtoEntity);
        } catch (ProdutoException e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public List<ProdutoEntity> getProdutos() {
        try {
            return produtoRepository.findAll();
        } catch (ProdutoException e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public Optional<ProdutoEntity> getProdutoId(Long id) {
        try {
            return produtoRepository.findById(id);
        } catch (ProdutoException e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public void atualizaProduto(Long id, ProdutoEntity produtoEntity) {
        try {
            if (produtoRepository.existsById(id)) {
                produtoRepository.save(produtoEntity);
            }
        } catch (ProdutoException e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public void produtoIdDeletado(Long id) {
        try {
            if (produtoRepository.existsById(id)) {
                produtoRepository.deleteById(id);
            }
        } catch (ProdutoException e) {
            throw new ProdutoException(e.getMessage());
        }
    }
}
