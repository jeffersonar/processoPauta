package br.com.jefferson.pautaApi.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "t_votacao")
@SequenceGenerator(name = "S_VOTACAO", sequenceName = "S_VOTACAO", initialValue = 1, allocationSize = 1)
public class Votacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_VOTACAO")
    @Column(name = "isn_votacao")
    private Integer isnVotacao;
    
    @Column(name = "isn_sessao")
    private Integer isnSessao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dat_cadastro")
    private Date datCadastro;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="voto")
    private Boolean voto;
    
    @ManyToOne
    @JoinColumn(name="isn_sessao", referencedColumnName = "isn_sessao",insertable = false, updatable = false)
    private Sessao sessao;

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Integer getIsnVotacao() {
        return isnVotacao;
    }

    public void setIsnVotacao(Integer isnVotacao) {
        this.isnVotacao = isnVotacao;
    }

    public Integer getIsnSessao() {
        return isnSessao;
    }

    public void setIsnSessao(Integer isnSessao) {
        this.isnSessao = isnSessao;
    }

    public Date getDatCadastro() {
        return datCadastro;
    }

    public void setDatCadastro(Date datCadastro) {
        this.datCadastro = datCadastro;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
