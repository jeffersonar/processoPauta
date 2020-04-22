package br.com.jefferson.pautaApi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade do Banco de Dados
 * @author jefferson
 */
@Entity
@Table(name = "t_sessao")
@SequenceGenerator(name = "S_SESSAO", sequenceName = "S_SESSAO", initialValue = 1, allocationSize = 1)
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_SESSAO")
    @Column(name = "isn_sessao")
    private Integer isnSessao;

    @Column(name = "isn_pauta")
    private Integer insPauta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dat_inicio")
    private Date datInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dat_fim")
    private Date datFim;

    @ManyToOne
    @JoinColumn(name = "isn_pauta", referencedColumnName = "isn_pauta", insertable = false, updatable = false)
    private Pauta pauta;

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }
    
    

    public Integer getIsnSessao() {
        return isnSessao;
    }

    public void setIsnSessao(Integer isnSessao) {
        this.isnSessao = isnSessao;
    }

    public Integer getInsPauta() {
        return insPauta;
    }

    public void setInsPauta(Integer insPauta) {
        this.insPauta = insPauta;
    }

    public Date getDatInicio() {
        return datInicio;
    }

    public void setDatInicio(Date datInicio) {
        this.datInicio = datInicio;
    }

    public Date getDatFim() {
        return datFim;
    }

    public void setDatFim(Date datFim) {
        this.datFim = datFim;
    }

}
