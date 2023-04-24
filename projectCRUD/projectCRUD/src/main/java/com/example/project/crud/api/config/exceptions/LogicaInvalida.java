package com.example.project.crud.api.config.exceptions;

public class LogicaInvalida extends RuntimeException {

    public LogicaInvalida() {
        super();
    }

    public LogicaInvalida(String mensagem) {
        super(mensagem);
    }

    public LogicaInvalida(String mensagem, Throwable ex) {
        super(mensagem, ex);
    }

    public LogicaInvalida(Throwable ex) {
        super(ex);
    }
}
