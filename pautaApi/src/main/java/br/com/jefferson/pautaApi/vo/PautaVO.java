/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.vo;

import br.com.jefferson.pautaApi.entity.Pauta;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jepherson
 */
public class PautaVO {

    private Integer codePauta;
    
    private Date dataCadastro;
    
    private String descricao;
    
    private Date dataConclusao;

    public PautaVO() {
    }
    
    public PautaVO(Pauta pauta) {
        this.codePauta = pauta.getIsnPauta();
        this.dataCadastro = pauta.getDatCadastro();
        this.dataConclusao = pauta.getDatConclusao();
        this.descricao = pauta.getDscPauta();
    }

    public Integer getCodePauta() {
        return codePauta;
    }

    public void setCodePauta(Integer codePauta) {
        this.codePauta = codePauta;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    
    
    
}
