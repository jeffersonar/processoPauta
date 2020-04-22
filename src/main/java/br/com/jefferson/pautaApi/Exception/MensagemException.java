/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.Exception;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jefferson
 */
public class MensagemException  {

    private String mensagem;
    private int code;
    private String status;
    private String nomeObject;
    private List<GenericException> errors;

    public MensagemException() {
    }

    public MensagemException(String mensagem, int code, String status, String nomeObject, List<GenericException> errors) {
        this.mensagem = mensagem;
        this.code = code;
        this.status = status;
        this.nomeObject = nomeObject;
        this.errors = errors;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeObject() {
        return nomeObject;
    }

    public void setNomeObject(String nomeObject) {
        this.nomeObject = nomeObject;
    }

    public List<GenericException> getErrors() {
        return errors;
    }

    public void setErrors(List<GenericException> errors) {
        this.errors = errors;
    }


}
