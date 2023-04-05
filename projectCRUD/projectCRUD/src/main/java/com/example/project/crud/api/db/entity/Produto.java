package com.example.project.crud.api.db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_produtos", sequenceName = "seq_itens", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;
    private double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
