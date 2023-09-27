package com.example.project.crud.api.controller;

import com.example.project.crud.api.service.ProdutoImpl;
import com.example.project.crud.api.documentation.DocInterface;
import com.example.project.crud.api.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/produtos", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "ProdutoController", description = "crud de produtos")
public class ProdutoController implements DocInterface {

    @Autowired
    ProdutoImpl produtoImpl;


    @PostMapping
    public ResponseEntity<ProdutoEntity> criarProduto (
            @RequestBody ProdutoEntity produtoEntity
    ) {
        return ResponseEntity.ok(produtoImpl.criarProduto(produtoEntity));
    }


    @GetMapping("/lista-produtos")
    public ResponseEntity<List<ProdutoEntity>> listaProdutos() {
        return ResponseEntity.ok(produtoImpl.getProdutos());
    }


    @GetMapping("/lista-produto/{id}")
    public ResponseEntity<ProdutoEntity> getProdutoId (
            @PathVariable(name = "id") Long id
    ) {
        Optional<ProdutoEntity> produtoId = produtoImpl.getProdutoId(id);
        if (produtoId.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualiza-produto/{id}")
    public ResponseEntity<?> atualizaProduto (
            @PathVariable (name = "id") Long id,
            @RequestBody ProdutoEntity produtoEntity
    ) {
        produtoImpl.atualizaProduto(id, produtoEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleta-produto/{id}")
    public ResponseEntity<?> produtoIdDeletado (
            @PathVariable(name = "id") Long id
    ) {
        produtoImpl.produtoIdDeletado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
