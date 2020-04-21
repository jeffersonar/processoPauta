/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jefferson
 */
@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException{
    
    public NoContentException(String mensagem){
        super(mensagem);
    }
    
}
