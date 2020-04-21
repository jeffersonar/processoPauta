package br.com.jefferson.pautaApi.vo;

import br.com.jefferson.pautaApi.entity.Votacao;
import java.text.SimpleDateFormat;

/**
 * Objeto de Saida do endpoint
 * @author jefferson
 */
public class VotacaoVO {

    private Integer codeVotacao;

    private Integer codeSessao;

    private String codeUsuario;

    private String dataVotacao;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public VotacaoVO(Votacao votacao) {
        this.codeVotacao = votacao.getIsnVotacao();
        this.codeSessao = votacao.getIsnSessao();
        this.codeUsuario = votacao.getCpf();
        this.dataVotacao = sdf.format(votacao.getDatCadastro());
    }

    public Integer getCodeVotacao() {
        return codeVotacao;
    }

    public void setCodeVotacao(Integer codeVotacao) {
        this.codeVotacao = codeVotacao;
    }

    public Integer getCodeSessao() {
        return codeSessao;
    }

    public void setCodeSessao(Integer codeSessao) {
        this.codeSessao = codeSessao;
    }

    public String getCodeUsuario() {
        return codeUsuario;
    }

    public void setCodeUsuario(String codeUsuario) {
        this.codeUsuario = codeUsuario;
    }

    public String getDataVotacao() {
        return dataVotacao;
    }

    public void setDataVotacao(String dataVotacao) {
        this.dataVotacao = dataVotacao;
    }

}
