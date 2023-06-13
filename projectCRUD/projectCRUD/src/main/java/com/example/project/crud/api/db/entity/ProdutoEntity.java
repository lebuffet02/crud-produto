package com.example.project.crud.api.db.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;

    private String nome;
    private String descricao;
    private double preco;
}


