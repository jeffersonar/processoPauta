package br.com.jefferson.pautaApi.vo;

import br.com.jefferson.pautaApi.entity.Pauta;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Objeto de Saida do endpoint
 * @author jefferson
 */
public class PautaVO {

    private Integer codePauta;
    
    private String dataCadastro;
    
    private String descricao;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public PautaVO() {
    }
    
    public PautaVO(Pauta pauta) {
        this.codePauta = pauta.getIsnPauta();
        this.dataCadastro = sdf.format(pauta.getDatCadastro());
        this.descricao = pauta.getDscPauta();
    }

    public Integer getCodePauta() {
        return codePauta;
    }

    public void setCodePauta(Integer codePauta) {
        this.codePauta = codePauta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    
}
