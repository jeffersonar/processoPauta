/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Objeto de Entrada do Endpoint
 * @author jefferson
 */
public class VotacaoDTO implements Serializable {

    @NotNull(message = "{uuid.not.blank}")
    private String cpf;

    @NotNull(message = "{voto.not.blank}")
    private String voto;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getVoto() {
        return voto;
    }
    
    public void setVoto(String voto) {
        this.voto = voto;
    }

}
