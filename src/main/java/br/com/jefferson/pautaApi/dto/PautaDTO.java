package br.com.jefferson.pautaApi.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 * Objeto de Entrada do Endpoint
 * @author jefferson
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
