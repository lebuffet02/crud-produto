package com.example.project.crud.api.controller;

import com.example.project.crud.api.documentation.DocInterface;
import com.example.project.crud.api.record.ProdutoDto;
import com.example.project.crud.api.service.ProdutoImpl;
import com.example.project.crud.api.external.ResponseExternal;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/produtos", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "ProdutoController", description = "Crud de produtos")
public class ProdutoController implements DocInterface {

    @Autowired
    ProdutoImpl produtoImpl;

    @GetMapping
    public ResponseExternal<Page<ProdutoDto>> listaProdutos(
            @PageableDefault Pageable pageable) {
        return new ResponseExternal<>(produtoImpl.getProdutos(pageable));
    }

    @PostMapping
    public ResponseExternal<Optional<ProdutoDto>> criarProduto (
            @RequestBody @Valid ProdutoDto produtoDto) {
        return new ResponseExternal<>(produtoImpl.criarProduto(produtoDto));
    }

    @GetMapping("/{id}")
    public ResponseExternal<Optional<ProdutoDto>> getProdutoId (
            @PathVariable("id") @NonNull Long id) {
        return new ResponseExternal<>(produtoImpl.getProdutoId(id));
    }

    @PutMapping("/{id}")
    public ResponseExternal<Optional<ProdutoDto>> atualizaProduto (
            @PathVariable ("id") @NonNull Long id,
            @RequestBody @Valid ProdutoDto produtoDto) {
        return new ResponseExternal<>(produtoImpl.atualizarProduto(id, produtoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseExternal<?> produtoIdDeletado (
            @PathVariable("id") @NonNull Long id) {
        produtoImpl.produtoIdDeletado(id);
        return new ResponseExternal<>();
    }

    @DeleteMapping
    public ResponseExternal<?> deletarTodos() {
        produtoImpl.deletarTodos();
        return new ResponseExternal<>();
    }
}
