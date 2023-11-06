package com.example.project.crud.api.record;


import com.example.project.crud.api.constants.StatusProduto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonPropertyOrder({ "id", "nome", "descricao"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private StatusProduto statusProduto;
}



