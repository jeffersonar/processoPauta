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

    public String getDscPauta() {
        return dscPauta;
    }

    public void setDscPauta(String dscPauta) {
        this.dscPauta = dscPauta;
    }
    
}
