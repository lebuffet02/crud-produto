package com.example.project.crud.api.exceptions;

public class ProductErrorException extends RuntimeException {

    public ProductErrorException() {
        super();
    }

    public ProductErrorException(String mensagem) {
        super(mensagem);
    }

    public ProductErrorException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }

    public ProductErrorException(Throwable ex) {
        super(ex);
    }
}
