/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.Exception;

/**
 *
 * @author jepherson
 */
public class GenericException {
 
    private String mensagem;
    private String campo;
    private Object parameter;

    public GenericException(String mensagem, String campo, Object parameter) {
        this.mensagem = mensagem;
        this.campo = campo;
        this.parameter = parameter;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

}
