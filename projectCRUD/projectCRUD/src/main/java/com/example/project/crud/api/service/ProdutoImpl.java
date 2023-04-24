package com.example.project.crud.api.service;

import com.example.project.crud.api.config.exceptions.LogicaInvalida;
import com.example.project.crud.api.db.entity.Produto;
import com.example.project.crud.api.db.repository.ProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProdutoImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    private ObjectMapper mapper;


    @Override
    public Produto criarProduto(Produto produto) {
        try {
            return produtoRepository.save(produto);
        } catch (LogicaInvalida e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Produto> getProdutos() {
        try {
            return produtoRepository.findAll();
        } catch (LogicaInvalida e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Produto> getProdutoId(Long id) {
        try {
            return produtoRepository.findById(id);
        } catch (LogicaInvalida e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void atualizaProduto(Long id, Produto produto) {
        try {
            if (produtoRepository.existsById(id)) {
                log.info("Atualizando produto...");
                produtoRepository.save(produto);
            }
            log.info("Não foi possível atualizar");
        } catch (LogicaInvalida e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void produtoIdDeletado(Long id) {
        try {
            if (!produtoRepository.existsById(id)) {
                log.info("Não foi possível deletar");
            }
            log.info("Deletando produto...");
            produtoRepository.deleteById(id);

        } catch (LogicaInvalida e) {
            throw new RuntimeException();
        }
    }


//    private Produto setProduto(ProdutoDTO produtoDTO) {
//        Produto produto = converteParaProduto(produtoDTO);
//        produto.setNome(produtoDTO.getNome());
//        produto.setDescricao(produtoDTO.getDescricao());
//        produto.setPreco(produtoDTO.getPreco());
//        return produto;
//    }
//
//    private Produto converteParaProduto(ProdutoDTO produtoDTO) {
//        return this.mapper.convertValue(produtoDTO, Produto.class);
//    }
//
//    private ProdutoDTO convertParaDTO(Produto produto) {
//        return this.mapper.convertValue(produto, ProdutoDTO.class);
//    }

}
