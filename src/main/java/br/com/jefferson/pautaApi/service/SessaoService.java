/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.dto.SessaoDTO;
import br.com.jefferson.pautaApi.entity.Sessao;
import br.com.jefferson.pautaApi.vo.SessaoVO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jefferson
 */
public interface SessaoService {
    
    
    public SessaoVO criarSessao(SessaoDTO sessaoDto);
    
    public SessaoVO getSessao(Integer isnSessao);
    
    public void validar(Optional<Sessao> sessao);
    
    public void validar(Integer idSessao);
    
}
