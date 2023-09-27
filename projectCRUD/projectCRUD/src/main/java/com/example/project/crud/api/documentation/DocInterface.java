package com.example.project.crud.api.documentation;

import com.example.project.crud.api.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface DocInterface {

    @Operation(summary = "Adiciona um novo produto",
            security = {
                @SecurityRequirement(name = "bearerAuth")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    ResponseEntity<ProdutoEntity> criarProduto (@RequestBody ProdutoEntity produtoEntity);

    @Operation(summary = "Lista todos os produtos",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    ResponseEntity<List<ProdutoEntity>> listaProdutos();


    @Operation(summary = "Lista produto pelo id",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    ResponseEntity<ProdutoEntity> getProdutoId (@PathVariable(name = "id") Long id);


    @Operation(summary = "Atualiza produto pelo id",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    ResponseEntity<?> atualizaProduto (@PathVariable (name = "id") Long id, @RequestBody ProdutoEntity produtoEntity);


    @Operation(summary = "Delete produto pelo id",
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Lista de produtos não encontrada"),
            @ApiResponse(responseCode = "404", description = "Erro ao buscar lista de produtos"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a ação - (Internal Error)"),
    })
    ResponseEntity<?> produtoIdDeletado (@PathVariable(name = "id") Long id);
}
