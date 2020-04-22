package br.com.jefferson.pautaApi.vo;

import java.io.Serializable;

/**
 *
 * @author jefferson
 */
public class UsuarioVO implements Serializable{
    
    private String status;

    public UsuarioVO() {
    }

    public UsuarioVO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
