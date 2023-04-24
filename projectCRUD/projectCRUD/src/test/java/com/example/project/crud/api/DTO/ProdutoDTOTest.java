//package com.example.project.crud.api.DTO;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//@ExtendWith(MockitoExtension.class)
//class ProdutoDTOTest {
//
//    @Test
//    void testaMetodoConstrutorNaoNulo() {
//        assertThat(new ProdutoDTO("nomeDTO", "descriçãoDTO", 1.0)).isNotNull();
//    }
//
//    @Test
//    void testaMetodoConstrutorNulo() {
//        Assertions.assertNotEquals(new ProdutoDTO(null, null, 0.0), getProdutoDTO());
//    }
//
//    @Test
//    void testaGettersPresentesNoDto() {
//        assertThat(getProdutoDTO().getNome()).isNotNull();
//        assertThat(getProdutoDTO().getDescricao()).isNotNull();
//        assertThat(getProdutoDTO().getPreco()).isNotNull();
//    }
//
//    private ProdutoDTO getProdutoDTO() {
//        ProdutoDTO produtoDTO = new ProdutoDTO();
//        produtoDTO.setDescricao("descriçãoDTO");
//        produtoDTO.setNome("nomeDTO");
//        produtoDTO.setPreco(23.4);
//        return produtoDTO;
//    }
//}