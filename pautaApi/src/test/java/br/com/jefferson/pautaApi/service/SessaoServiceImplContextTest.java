package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.dto.SessaoDTO;
import br.com.jefferson.pautaApi.entity.Sessao;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author jefferson
 */
public abstract class SessaoServiceImplContextTest {
    
    public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public Sessao getSessao() throws ParseException{
        Sessao sessao = new Sessao();
        sessao.setDatInicio(sdf.parse("21/04/2020 11:30:12"));
        sessao.setDatFim(sdf.parse("24/04/2020 11:30:12"));
        sessao.setInsPauta(1);
        sessao.setIsnSessao(1);
        return sessao;
    }
    
    public SessaoDTO getSessaoDTO(){
        SessaoDTO retorno = new SessaoDTO();
        retorno.setCodePauta(1);
        retorno.setMinutosPauta(12);
        return retorno;
    }
    
     public SessaoDTO getSessaoDTOErro(){
        SessaoDTO retorno = new SessaoDTO();
        retorno.setCodePauta(1);
        retorno.setMinutosPauta(12);
        return retorno;
    }
}
