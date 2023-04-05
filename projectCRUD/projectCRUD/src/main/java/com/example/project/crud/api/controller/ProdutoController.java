package com.example.project.crud.api.controller;

import com.example.project.crud.api.DTO.ProdutoDTO;
import com.example.project.crud.api.db.entity.Produto;
import com.example.project.crud.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @Operation(summary = "Endpoint para criar um produto através de um DTO")
    @RequestMapping(path = "/criar-produto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> criarProduto(
            @RequestBody (required = false) ProdutoDTO produtoDTO
    ) {
        Produto produto = produtoService.criarProduto(produtoDTO);
        return ResponseEntity.ok(produto);
    }


    @Operation(summary = "Endpoint para listar todos os produtos presentes")
    @RequestMapping(value = "/lista-produtos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> listaProdutos() {
        List<Produto> produtos = produtoService.getProdutos();
        return ResponseEntity.ok(produtos);
    }


    @Operation(summary = "Endpoint para listar um produto específico")
    @RequestMapping(value = "/lista-produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> getProdutoId(
            @PathVariable(name = "id") Long id
    ) {
        Optional<Produto> produtoId = produtoService.getProdutoId(id);
        return produtoId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(summary = "Endpoint para deletar um produto específico")
    @RequestMapping(value = "/deleta-produto/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> produtoIdDeletado(
            @PathVariable(name = "id") Long id
    ) {
        if (produtoService.produtoIdDeletado(id)) {
            return ResponseEntity.ok(produtoService.produtoIdDeletado(id));
        }
        return new ResponseEntity<>(HttpStatus.valueOf("Id não excluído!"));
    }
}
