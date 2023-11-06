package com.example.project.crud.api.component;

import com.example.project.crud.api.entity.ProdutoEntity;
import com.example.project.crud.api.record.ProdutoDto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoComponent {

    public ProdutoEntity getProdutoEntity(ProdutoDto produtoDto) {
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(produtoDto.getId());
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setPreco(produtoDto.getPreco());
        produto.setStatusProduto(produtoDto.getStatusProduto());
        return produto;
    }
}
