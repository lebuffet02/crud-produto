package com.example.project.crud.api.exceptions;

public class ProdutoException extends RuntimeException {

    public ProdutoException() {
        super();
    }

    public ProdutoException(String mensagem) {
        super(mensagem);
    }

    public ProdutoException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
