package com.example.project.crud.api.controller;

import com.example.project.crud.entity.ProdutoEntity;
import com.example.project.crud.api.service.ProdutoImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
public class ProdutoController {

    @Autowired
    ProdutoImpl produtoImpl;


    @Operation(summary = "Adiciona um novo produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PostMapping
    public ResponseEntity<ProdutoEntity> criarProduto (
            @RequestBody ProdutoEntity produtoEntity
    ) {
        return ResponseEntity.ok(produtoImpl.criarProduto(produtoEntity));
    }

    @Operation(summary = "Lista todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @GetMapping("/lista-produtos")
    public ResponseEntity<List<ProdutoEntity>> listaProdutos() {
        return ResponseEntity.ok(produtoImpl.getProdutos());
    }


    @Operation(summary = "Lista produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
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


    @Operation(summary = "Atualiza produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @PutMapping("/atualiza-produto/{id}")
    public ResponseEntity<?> atualizaProduto (
            @PathVariable (name = "id") Long id,
            @RequestBody ProdutoEntity produtoEntity
    ) {
        produtoImpl.atualizaProduto(id, produtoEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Delete produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    @DeleteMapping("/deleta-produto/{id}")
    public ResponseEntity<?> produtoIdDeletado (
            @PathVariable(name = "id") Long id
    ) {
        produtoImpl.produtoIdDeletado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
