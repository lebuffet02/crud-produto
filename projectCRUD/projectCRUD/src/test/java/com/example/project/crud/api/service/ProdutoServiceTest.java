//package com.example.project.crud.api.service;
//
//import com.example.project.crud.api.DTO.ProdutoDTO;
//import com.example.project.crud.api.db.repository.ProdutoRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//class ProdutoServiceTest {
//
//    @Mock
//    ProdutoRepository produtoRepository;
//
//    @InjectMocks
//    ProdutoImpl service;
//
//
//    @Test
//    void dadoMetodoCriarProdutoEntaoTestarEsteMetodoGerandoUmaExcecaoDeNullPointerException() { // given - when - then
//        Assertions.assertThrows(NullPointerException.class, () -> service.criarProduto(new ProdutoDTO(null, "descriçãoDTO", 76.9)));
//    }
//
//    @Test
//    void dadoMetodoProdutoIdDeletadoEntaoTestarEsteMetodo() { //never pois não teve interação com o crud
//        verify(produtoRepository, never()).deleteById(anyLong());
//    }
//
//    @Test
//    void dadoMetodoGetProdutosEntaoTestarEsteMetodo() { //never pois não teve interação com o crud
//        verify(produtoRepository, never()).findAll();
//    }
//}