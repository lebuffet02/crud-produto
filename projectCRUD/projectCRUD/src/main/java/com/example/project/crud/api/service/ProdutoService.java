package com.example.project.crud.api.service;

import com.example.project.crud.api.DTO.ProdutoDTO;
import com.example.project.crud.api.db.entity.Produto;
import com.example.project.crud.api.db.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    public Produto criarProduto(ProdutoDTO produtoDTO) {
        if (produtoDTO.getNome() == null || produtoDTO.getPreco() <= 0.0) {
            throw new NullPointerException("DTO está vazio");
        }
        Produto produto = getProduto(produtoDTO);
        return produtoRepository.save(produto);
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoId(Long id) {
        return produtoRepository.findById(id);
    }

    public boolean produtoIdDeletado(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Produto getProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return produto;
    }
}
