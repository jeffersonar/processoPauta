/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Objeto de Entrada do Endpoint
 * @author jefferson
 */
public class SessaoDTO  implements Serializable{
    
    @NotNull(message = "{isnPauta.not.blank}")
    private Integer codePauta;
    
    private Integer minutosPauta;

    public Integer getCodePauta() {
        return codePauta;
    }

    public void setCodePauta(Integer codePauta) {
        this.codePauta = codePauta;
    }

    public Integer getMinutosPauta() {
        return minutosPauta;
    }

    public void setMinutosPauta(Integer minutosPauta) {
        this.minutosPauta = minutosPauta;
    }
    
}
