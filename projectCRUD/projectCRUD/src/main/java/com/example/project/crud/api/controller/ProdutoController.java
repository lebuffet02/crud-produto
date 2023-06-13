package com.example.project.crud.api.controller;

import com.example.project.crud.api.db.entity.Produto;
import com.example.project.crud.api.service.ProdutoImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoImpl produtoImpl;


    @ApiOperation(value = "Endpoint para criar um produto",
        response = Produto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "produto não inserido corretamente"),
            @ApiResponse(code = 404, message = "erro ao criar um produto")
    })
    @RequestMapping(path = "/criar-produto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> criarProduto (
            @RequestBody Produto produto
    ) {
        return ResponseEntity.ok(produtoImpl.criarProduto(produto));
    }


    @ApiOperation(value = "Endpoint para listar todos os produtos presentes",
            response = Produto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "lista de produtos não encontrada"),
            @ApiResponse(code = 404, message = "erro ao buscar lista de produtos")
    })
    @RequestMapping(path = "/lista-produtos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> listaProdutos() {
        return ResponseEntity.ok(produtoImpl.getProdutos());
    }


    @ApiOperation(value = "Endpoint para listar um produto específico",
            response = Produto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "id do produto não buscado corretamente"),
            @ApiResponse(code = 404, message = "erro ao buscar o produto pelo seu id")
    })
    @RequestMapping(path = "/lista-produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> getProdutoId (
            @PathVariable(name = "id") Long id
    ) {
        Optional<Produto> produtoId = produtoImpl.getProdutoId(id);
        if (produtoId.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Endpoint para atualizar um produto específico",
            response = Produto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "id do produto não foi atualizado corretamente"),
            @ApiResponse(code = 404, message = "erro ao atualizar o produto")
    })
    @RequestMapping(path = "/atualiza-produto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaProduto (
            @PathVariable (name = "id") Long id,
            @RequestBody Produto produto
    ) {
        produtoImpl.atualizaProduto(id, produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint para deletar um produto específico",
            response = Produto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "id do produto não foi deletado"),
            @ApiResponse(code = 404, message = "erro ao deletar o produto")
    })
    @RequestMapping(path = "/deleta-produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> produtoIdDeletado (
            @PathVariable(name = "id") Long id
    ) {
        produtoImpl.produtoIdDeletado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
