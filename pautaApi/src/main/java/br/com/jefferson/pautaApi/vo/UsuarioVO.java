package br.com.jefferson.pautaApi.vo;

/**
 *
 * @author jefferson
 */
public class UsuarioVO {
    
    private String status;

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
