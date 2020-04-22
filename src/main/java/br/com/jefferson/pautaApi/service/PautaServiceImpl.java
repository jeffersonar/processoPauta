package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.Exception.NoContentException;
import br.com.jefferson.pautaApi.Exception.NotFoundException;
import br.com.jefferson.pautaApi.dto.PautaDTO;
import br.com.jefferson.pautaApi.entity.Pauta;
import br.com.jefferson.pautaApi.repository.PautaRepository;
import br.com.jefferson.pautaApi.vo.PautaVO;
import br.com.jefferson.pautaApi.vo.ResultadoPautaVO;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Camada de regra de negocio
 * @author jefferson
 */
@Service
public class PautaServiceImpl implements PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    /**
     * Salvar uma nova pauta
     * @param pautaDTO
     * @return 
     */
    @Override
    public PautaVO salvarPauta(PautaDTO pautaDTO) {
        Pauta pauta = new Pauta();
        pauta.setDatCadastro(new Date());
        pauta.setDscPauta(pautaDTO.getDescricao());
        Pauta retorno = pautaRepository.saveAndFlush(pauta);
        return new PautaVO(retorno);
    }

    /**
     * Buscar Pauta por codePauta
     * @param codePauta
     * @return 
     */
    @Override
    public PautaVO pesquisarPorCodigo(Integer codePauta) {
        Optional<Pauta> pauta = pautaRepository.findById(codePauta);
        if(!pauta.isPresent()){
            throw new NoContentException("Não existe pauta com esse code");
        }
        return new PautaVO(pauta.get());
    }

    /**
     * Validar Pauta
     * @param pauta 
     */
    @Override
    public void validar(Optional<Pauta> pauta){
        if (!pauta.isPresent()) {
            throw new NotFoundException("Code Pauta inválido");
        }
    }
    
    /**
     * Validar pauta
     * @param codePauta 
     */
    @Override
    public void validar(Integer codePauta) {
        Optional<Pauta> pauta = pautaRepository.findById(codePauta);
        validar(pauta);
    }

    /**
     * Resultado da votação por pauta
     * @param code
     * @return 
     */
    @Override
    public List<ResultadoPautaVO> resultadoPauta(Integer code) {
        List<ResultadoPautaVO> lista = pautaRepository.resultadoPauta(code);
        if(lista.isEmpty()){
            throw new NoContentException("Não existe voto nesta pauta");
        }
        return lista;
    }

}
