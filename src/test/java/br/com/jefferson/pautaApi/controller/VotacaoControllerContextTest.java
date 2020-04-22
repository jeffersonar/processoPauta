/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.dto.VotacaoDTO;
import br.com.jefferson.pautaApi.entity.Votacao;
import br.com.jefferson.pautaApi.vo.VotacaoVO;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author jefferson
 */
public abstract class VotacaoControllerContextTest extends GenericControllerContextTest {

     public VotacaoDTO getVotacaoDTOVazio() {
        return new VotacaoDTO();
    }
     
    public VotacaoDTO getVotacaoDTO() {
        VotacaoDTO retorno = new VotacaoDTO();
        retorno.setCpf("17405230083");
        retorno.setVoto("Sim");
        return retorno;
    }

    public Votacao getVotacao() throws ParseException {
        Votacao retorno = new Votacao();
        retorno.setIsnVotacao(1);
        retorno.setCpf("17405230083");
        retorno.setVoto(Boolean.TRUE);
        retorno.setDatCadastro(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("21/01/2020 11:54:12"));
        return retorno;
    }

    public VotacaoVO getVotacaoVO() throws ParseException {
        Votacao votacao = new Votacao();
        votacao.setIsnVotacao(1);
        votacao.setCpf("17405230083");
        votacao.setVoto(Boolean.TRUE);
        votacao.setDatCadastro(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("21/01/2020 11:54:12"));
        VotacaoVO votacaoVO = new VotacaoVO(votacao);
        return votacaoVO;

    }
}
