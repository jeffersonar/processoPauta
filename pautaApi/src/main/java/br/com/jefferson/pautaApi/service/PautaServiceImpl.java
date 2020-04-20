/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.Exception.MensagemException;
import br.com.jefferson.pautaApi.Exception.NotFoundException;
import br.com.jefferson.pautaApi.dto.PautaDTO;
import br.com.jefferson.pautaApi.entity.Pauta;
import br.com.jefferson.pautaApi.repository.PautaRepository;
import br.com.jefferson.pautaApi.vo.PautaVO;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

/**
 *
 * @author jepherson
 */
@Service
public class PautaServiceImpl implements PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    @Override
    public PautaVO salvarPauta(PautaDTO pautaDTO) {
        Pauta pauta = new Pauta();
        pauta.setDatCadastro(new Date());
        pauta.setDscPauta(pautaDTO.getDescricao());
        pauta = pautaRepository.saveAndFlush(pauta);
        return new PautaVO(pauta);
    }

    @Override
    public PautaVO pesquisarPorCodigo(Integer codePauta) {
        Optional<Pauta> pauta = pautaRepository.findById(codePauta);
        validar(pauta);
        return new PautaVO(pauta.get());
    }

    @Override
    public PautaVO concluirPauta(Integer codePauta) {
        Optional<Pauta> pauta = pautaRepository.findById(codePauta);
        validar(pauta);
        pauta.get().setDatConclusao(new Date());
        Pauta retorno = pautaRepository.saveAndFlush(pauta.get());
        return new PautaVO(retorno);

    }

    @Override
    public void validar(Optional<Pauta> pauta){
        if (!pauta.isPresent()) {
            throw new NotFoundException("Code Pauta inválido");
        }
        if (pauta.get().getDatConclusao() != null) {
            throw new NotFoundException("Pauta já concluida");
        }
    
    }
    @Override
    public void validar(Integer codePauta) {
        Optional<Pauta> pauta = pautaRepository.findById(codePauta);
        validar(pauta);
    }

}
