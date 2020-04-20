/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.repository;

import br.com.jefferson.pautaApi.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jepherson
 */
@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer>{
    
}
