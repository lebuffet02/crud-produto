package com.example.project.crud.api.exceptions.response;

import com.example.project.crud.api.exceptions.EntidadeException;
import com.example.project.crud.api.exceptions.ProdutoException;
import com.example.project.crud.api.utils.TimeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<Object> productErrorException(ProdutoException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadeException.class)
    public ResponseEntity<Object> entidadeException(EntidadeException e) {
        return new ResponseEntity<>(getMap(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    private Map<String, Object> getMap(String e) {
        Map<String, Object> body = new HashMap<>();
        body.put("Momento: ", TimeUtils.formatDate(new Date()));
        body.put("Status: ", HttpStatus.BAD_REQUEST.value());
        body.put("Mensagem: ", e);
        return body;
    }
}
