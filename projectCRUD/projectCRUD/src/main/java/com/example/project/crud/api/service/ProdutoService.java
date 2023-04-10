package com.example.project.crud.api.service;

import com.example.project.crud.api.DTO.ProdutoDTO;
import com.example.project.crud.api.db.entity.Produto;
import com.example.project.crud.api.db.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    private ObjectMapper mapper;


    public Produto criarProduto(ProdutoDTO produtoDTO) {
        if (produtoDTO.getNome() == null || produtoDTO.getPreco() <= 0.0) {
            throw new NullPointerException("DTO está vazio");
        }
        return produtoRepository.save(setProduto(produtoDTO));
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoId(Long id) {
        return produtoRepository.findById(id);
    }

    public void atualizaProduto(Long id, Produto produto) {
            if(produtoRepository.existsById(id)) {
                produtoRepository.save(produto);
            }
    }

    public void produtoIdDeletado(Long id) {
            produtoRepository.deleteById(id);
    }

    private Produto setProduto(ProdutoDTO produtoDTO) {
        Produto produto = converteParaProduto(produtoDTO);
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return produto;
    }

    private Produto converteParaProduto(ProdutoDTO produtoDTO) {
        return this.mapper.convertValue(produtoDTO, Produto.class);
    }

    private ProdutoDTO convertParaDTO(Produto produto) {
        return this.mapper.convertValue(produto, ProdutoDTO.class);
    }
}
