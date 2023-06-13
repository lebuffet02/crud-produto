package com.example.project.crud.api.controller;

import com.example.project.crud.api.db.entity.ProdutoEntity;
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
        response = ProdutoEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCESSO"),
            @ApiResponse(code = 400, message = "Produto não inserido corretamente"),
            @ApiResponse(code = 404, message = "Erro ao criar um produto")
    })
    @RequestMapping(path = "/criar-produto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoEntity> criarProduto (
            @RequestBody ProdutoEntity produtoEntity
    ) {
        return ResponseEntity.ok(produtoImpl.criarProduto(produtoEntity));
    }


    @ApiOperation(value = "Endpoint para listar todos os produtos presentes",
            response = ProdutoEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCESSO"),
            @ApiResponse(code = 400, message = "Lista de produtos não encontrada"),
            @ApiResponse(code = 404, message = "Erro ao buscar lista de produtos")
    })
    @RequestMapping(path = "/lista-produtos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoEntity>> listaProdutos() {
        return ResponseEntity.ok(produtoImpl.getProdutos());
    }


    @ApiOperation(value = "Endpoint para listar um produto específico",
            response = ProdutoEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCESSO"),
            @ApiResponse(code = 400, message = "Id do produto não buscado corretamente"),
            @ApiResponse(code = 404, message = "Erro ao buscar o produto pelo seu id")
    })
    @RequestMapping(path = "/lista-produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoEntity> getProdutoId (
            @PathVariable(name = "id") String id
    ) {
        Optional<ProdutoEntity> produtoId = produtoImpl.getProdutoId(id);
        if (produtoId.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Endpoint para atualizar um produto específico",
            response = ProdutoEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCESSO"),
            @ApiResponse(code = 400, message = "Id do produto não foi atualizado corretamente"),
            @ApiResponse(code = 404, message = "Erro ao atualizar o produto")
    })
    @RequestMapping(path = "/atualiza-produto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaProduto (
            @PathVariable (name = "id") String id,
            @RequestBody ProdutoEntity produtoEntity
    ) {
        produtoImpl.atualizaProduto(id, produtoEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint para deletar um produto específico",
            response = ProdutoEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCESSO"),
            @ApiResponse(code = 400, message = "Id do produto não foi deletado"),
            @ApiResponse(code = 404, message = "Erro ao deletar o produto")
    })
    @RequestMapping(path = "/deleta-produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> produtoIdDeletado (
            @PathVariable(name = "id") String id
    ) {
        produtoImpl.produtoIdDeletado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
