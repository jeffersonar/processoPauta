/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author jepherson
 */
public class PautaDTO implements Serializable{
    
    @NotBlank(message = "{descricao.not.blank}")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
