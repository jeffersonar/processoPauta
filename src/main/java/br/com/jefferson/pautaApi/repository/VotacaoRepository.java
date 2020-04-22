/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.repository;

import br.com.jefferson.pautaApi.entity.Sessao;
import br.com.jefferson.pautaApi.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Camada de persistencia
 * @author jefferson
 */
@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Integer> {

    public Votacao findByIsnSessaoAndCpf(Integer nSessao, String cpf);
    
}
