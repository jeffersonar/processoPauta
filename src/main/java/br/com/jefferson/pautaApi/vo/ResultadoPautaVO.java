package br.com.jefferson.pautaApi.vo;

/**
 * Objeto de Saida do endpoint
 * @author jefferson
 */
public class ResultadoPautaVO {
    private Integer codePauta;
    
    private Integer codeSessao;
    
    private String voto;
    
    private Integer quantidade;

    public ResultadoPautaVO() {
    }
    
    
    public ResultadoPautaVO(Integer codePauta,Integer codeSessao,Boolean voto,Long quantidade){
        this.codePauta=codePauta;
        this.codeSessao = codeSessao;
        this.voto = voto?"Sim":"Não";
        this.quantidade = quantidade.intValue();
    }

    public Integer getCodePauta() {
        return codePauta;
    }

    public void setCodePauta(Integer codePauta) {
        this.codePauta = codePauta;
    }

    public Integer getCodeSessao() {
        return codeSessao;
    }

    public void setCodeSessao(Integer codeSessao) {
        this.codeSessao = codeSessao;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
