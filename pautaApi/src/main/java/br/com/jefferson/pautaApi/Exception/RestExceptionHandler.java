/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.Exception;

import br.com.jefferson.pautaApi.Exception.GenericException;
import br.com.jefferson.pautaApi.Exception.MensagemException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author jepherson
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<GenericException> errors = getErrors(ex);
        MensagemException errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private MensagemException getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<GenericException> errors) {
        return new MensagemException("Requisição possui campos inválidos", status.value(),
                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }

    private List<GenericException> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new GenericException(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
