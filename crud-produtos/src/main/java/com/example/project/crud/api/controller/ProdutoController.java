package com.example.project.crud.api.controller;

import com.example.project.crud.api.documentation.DocInterface;
import com.example.project.crud.api.entity.ProdutoEntity;
import com.example.project.crud.api.service.ProdutoImpl;
import com.example.project.crud.api.external.ResponseExternal;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/produtos", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "ProdutoController", description = "Crud de produtos")
public class ProdutoController implements DocInterface {

    @Autowired
    ProdutoImpl produtoImpl;


    @GetMapping
    public ResponseExternal<List<ProdutoEntity>> listaProdutos() {
        return new ResponseExternal<>(produtoImpl.getProdutos());
    }

    @PostMapping
    public ResponseExternal<ProdutoEntity> criarProduto (
            @RequestBody @Valid ProdutoEntity produtoEntity) {
        return new ResponseExternal<>(produtoImpl.criarProduto(produtoEntity));
    }

    @GetMapping("/lista-produto/{id}")
    public ResponseExternal<ProdutoEntity> getProdutoId (
            @PathVariable("id") Long id) {
        Optional<ProdutoEntity> produtoId = produtoImpl.getProdutoId(id);
        return produtoId.map(ResponseExternal::new).orElseGet(ResponseExternal::new);
    }

    @PutMapping("/atualiza-produto/{id}")
    public ResponseExternal<?> atualizaProduto (
            @PathVariable ("id") Long id,
            @RequestBody ProdutoEntity produtoEntity) {
        produtoImpl.atualizaProduto(id, produtoEntity);
        return new ResponseExternal<>();
    }

    @DeleteMapping("/deleta-produto/{id}")
    public ResponseExternal<?> produtoIdDeletado (
            @PathVariable("id") Long id) {
        produtoImpl.produtoIdDeletado(id);
        return new ResponseExternal<>();
    }
}
