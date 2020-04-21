package br.com.jefferson.pautaApi.vo;

import br.com.jefferson.pautaApi.entity.Sessao;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Objeto de Saida do endpoint
 * @author jefferson
 */
public class SessaoVO {

    private Integer codeSessao;
    
    private Integer codePauta;
    
    private String dataInicio;
    
    private String dataFim;
   
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public SessaoVO(Sessao retorno) {
        this.codeSessao = retorno.getIsnSessao();
        this.dataInicio = sdf.format(retorno.getDatInicio());
        this.dataFim = sdf.format(retorno.getDatFim());
        this.codePauta = retorno.getInsPauta();
    }

    public Integer getCodeSessao() {
        return codeSessao;
    }

    public void setCodeSessao(Integer codeSessao) {
        this.codeSessao = codeSessao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getCodePauta() {
        return codePauta;
    }

    public void setCodePauta(Integer codePauta) {
        this.codePauta = codePauta;
    }
    
    
    
}
