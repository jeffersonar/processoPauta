/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.dto.SessaoDTO;
import br.com.jefferson.pautaApi.entity.Sessao;
import br.com.jefferson.pautaApi.vo.SessaoVO;
import java.util.Date;

/**
 *
 * @author jefferson
 */
public abstract class SessaoControllerContextTest extends GenericControllerContextTest{
    
     public SessaoDTO getSessaoDTOIncorreto(){
        SessaoDTO retorno = new SessaoDTO();
        return retorno;
    }
    
    public SessaoDTO getSessaoDTO(){
        SessaoDTO retorno = new SessaoDTO();
        retorno.setCodePauta(1);
        retorno.setMinutosPauta(10);
        return retorno;
    }
    
    public Sessao getSessaoSalvo(){
        Sessao sessao = new Sessao();
        sessao.setInsPauta(1);
        sessao.setIsnSessao(1);
        sessao.setDatInicio(new Date());
        sessao.setDatFim(new Date());
        return sessao;
    }
    
    public SessaoVO getSessaoVO(){
        SessaoVO sessaoVO = new SessaoVO(getSessaoSalvo());
        return sessaoVO;
        
    }
}
