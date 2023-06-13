package com.example.project.crud.api.exceptions;

public class ErrorException extends RuntimeException {

    public ErrorException() {
        super();
    }

    public ErrorException(String mensagem) {
        super(mensagem);
    }

    public ErrorException(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }

    public ErrorException(Throwable ex) {
        super(ex);
    }
}
