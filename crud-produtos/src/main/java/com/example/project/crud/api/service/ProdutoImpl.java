package com.example.project.crud.api.service;

import com.example.project.crud.api.exceptions.EntidadeException;
import com.example.project.crud.api.exceptions.ProdutoException;
import com.example.project.crud.api.entity.ProdutoEntity;
import com.example.project.crud.api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProdutoImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    @Override
    public List<ProdutoEntity> getProdutos() {
        List<ProdutoEntity> pessoasEntityList;
        try {
            if(!CollectionUtils.isEmpty(produtoRepository.findAll())) {
                pessoasEntityList = produtoRepository.findAll().stream().collect(Collectors.toList());
                return pessoasEntityList;
            }
        } catch (ProdutoException e) {
            throw new ProdutoException(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public ProdutoEntity criarProduto(ProdutoEntity produtoEntity) {
        try {
            return produtoRepository.save(produtoEntity);
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
