/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.dto.PautaDTO;
import br.com.jefferson.pautaApi.entity.Pauta;
import br.com.jefferson.pautaApi.vo.ResultadoPautaVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jefferson
 */
public abstract class PautaServiceImplContextTest {

    public PautaDTO getPautaDTO() {
        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setDescricao("Teste 123");
        return pautaDTO;
    }

    public Pauta getPauta() {
        Pauta pauta = new Pauta();
        pauta.setDatCadastro(new Date());
        pauta.setDscPauta("Teste 123");
        return pauta;
    }

    public Pauta getPautaSalvar() {
        Pauta pauta = new Pauta();
        pauta.setDatCadastro(new Date());
        pauta.setDscPauta("Teste 123");
        pauta.setInsPauta(1);
        return pauta;
    }

    public Optional<Pauta> getOptionalPautaVazio() {
        Optional<Pauta> retorno = Optional.empty();
        return retorno;
    }
     public Optional<Pauta> getOptionalPautaSalvar() {
        Optional<Pauta> retorno = Optional.of(getPautaSalvar());
        return retorno;
    }


    public List<ResultadoPautaVO> getResultadoPautaVO() {
        List<ResultadoPautaVO> retorno = new ArrayList<>();
        retorno.add(new ResultadoPautaVO(1, 1, true, 154l));
        retorno.add(new ResultadoPautaVO(1, 1, false, 5254l));
        return retorno;
    }

     public List<ResultadoPautaVO> getResultadoPautaVOVazio() {
        List<ResultadoPautaVO> retorno = new ArrayList<>();
        return retorno;
    }
}
