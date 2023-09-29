package com.example.project.crud.api.exceptions;

public class EntidadeException extends RuntimeException {

    public EntidadeException() {
        super();
    }

    public EntidadeException(String mensagem) {
        super(mensagem);
    }

    public EntidadeException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }
}
