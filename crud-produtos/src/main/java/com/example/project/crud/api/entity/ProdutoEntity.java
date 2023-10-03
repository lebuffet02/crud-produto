package com.example.project.crud.api.entity;


import com.example.project.crud.api.constants.StatusProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity(name = "ProdutosEntity")
@Table(name = "produtos")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @NotBlank
    private String nome;

    @Column(name = "descricao")
    @NotBlank
    private String descricao;

    @Column(name = "preco")
    @NotBlank
    @Positive
    private double preco;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusProduto statusProduto;
}


