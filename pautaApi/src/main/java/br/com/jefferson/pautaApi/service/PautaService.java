/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.dto.PautaDTO;
import br.com.jefferson.pautaApi.entity.Pauta;
import br.com.jefferson.pautaApi.vo.PautaVO;
import br.com.jefferson.pautaApi.vo.ResultadoPautaVO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jefferson
 */
public interface PautaService {

    public PautaVO salvarPauta(PautaDTO pautaDTO);

    public PautaVO pesquisarPorCodigo(Integer codePauta);

    public void validar(Optional<Pauta> pauta);

    public void validar(Integer codePauta);
    
    public List<ResultadoPautaVO> resultadoPauta(Integer code) ;
}
