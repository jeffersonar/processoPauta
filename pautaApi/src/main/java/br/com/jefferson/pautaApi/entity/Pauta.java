/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jepherson
 */
@Entity
@Table(name="t_pauta")
@SequenceGenerator(name = "S_PAUTA", sequenceName = "S_PAUTA", initialValue = 1, allocationSize = 1)
public class Pauta implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "S_PAUTA")
    @Column(name="isn_pauta")
    private Integer isnPauta;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dat_cadastro")
    private Date datCadastro;
    
    @Column(name="dsc_pauta")
    private String dscPauta;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dat_conclusao")
    private Date datConclusao;

    public Date getDatCadastro() {
        return datCadastro;
    }

    public void setDatCadastro(Date datCadastro) {
        this.datCadastro = datCadastro;
    }

    public Integer getIsnPauta() {
        return isnPauta;
    }

    public void setInsPauta(Integer isnPauta) {
        this.isnPauta = isnPauta;
    }

    public Date getDatConclusao() {
        return datConclusao;
    }

    public void setDatConclusao(Date datConclusao) {
        this.datConclusao = datConclusao;
    }

    public String getDscPauta() {
        return dscPauta;
    }

    public void setDscPauta(String dscPauta) {
        this.dscPauta = dscPauta;
    }
    
}
