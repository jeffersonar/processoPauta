/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.dto.VotacaoDTO;
import br.com.jefferson.pautaApi.entity.Votacao;
import br.com.jefferson.pautaApi.vo.VotacaoVO;
import java.util.Optional;

/**
 *
 * @author jefferson
 */
public interface VotacaoService {
    
    public VotacaoVO votar(Integer isnSessao,VotacaoDTO votacaoDto) ;
    
    public void validar(VotacaoDTO votacaoDto);
    
}
