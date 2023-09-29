//package com.example.project.crud.api.controller;
//
//import com.example.project.crud.api.DTO.ProdutoDTO;
//import com.example.project.crud.api.db.entity.Produto;
//import com.example.project.crud.api.service.ProdutoImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//@ExtendWith(MockitoExtension.class)
//class ProdutoControllerTest {
//
//    @Mock
//    ProdutoImpl produtoImpl;
//
//    @InjectMocks
//    ProdutoController controller;
//
//
//    @Test
//    void dadoQueExisteUmEndpointParaCriarUmProdutoEntaoTestarAtributosNaoVazios() { // given - when - then
//        ProdutoDTO produtoDTO = getProdutoDTO();
//        controller.criarProduto(produtoDTO);
//        Mockito.verify(produtoImpl, Mockito.times(1)).criarProduto(produtoDTO);
//    }
//
//    @Test
//    void dadoQueExisteUmEndpointParaListarOsProdutosExistentesEntaoTestarAsInformacoesExistentes() {
//        controller.listaProdutos();
//        Mockito.verify(produtoImpl, Mockito.times(1)).getProdutos();
//    }
//
//    @Test
//    void dadoQueExisteUmEndpointParaListarUmProdutoExistenteCriadoEntaoTestarQueSeuIdNaoEIgual() {
//        controller.getProdutoId(1L);
//        Mockito.verify(produtoImpl, Mockito.times(1)).getProdutoId(1L);
//        Assertions.assertNotEquals(1L, getProduto());
//    }
//
//    @Test
//    void dadoQueExisteUmEndpointParaAtualizarUmProdutoExistenteEntaoTestarQueOcorreUmaChamadaDesteEnpoint() {
//        Produto produto = getProduto();
//        controller.atualizaProduto(1L, produto);
//        Mockito.verify(produtoImpl, Mockito.times(1)).atualizaProduto(1L, produto);
//    }
//
//    @Test
//    void dadoQueExisteUmEndpointParaDeletarUmProdutoExistenteEntaoTestarQueOcorreUmaChamadaDesteEnpoint() {
//        controller.produtoIdDeletado(1L);
//        Mockito.verify(produtoImpl, Mockito.times(1)).produtoIdDeletado(1L);
//    }
//
//
//    private Produto getProduto() {
//        Produto produto = new Produto();
//        produto.setId(2L);
//        return produto;
//    }
//
//
//    private ProdutoDTO getProdutoDTO() {
//        ProdutoDTO produtoDTO = new ProdutoDTO();
//        produtoDTO.setDescricao("descrição");
//        produtoDTO.setNome("nome");
//        produtoDTO.setPreco(15.5);
//        return produtoDTO;
//    }
//}