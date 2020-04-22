package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.Exception.NotFoundException;
import br.com.jefferson.pautaApi.dto.SessaoDTO;
import br.com.jefferson.pautaApi.entity.Sessao;
import br.com.jefferson.pautaApi.repository.SessaoRepository;
import br.com.jefferson.pautaApi.vo.SessaoVO;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Camada de regra de negocio
 *
 * @author jefferson
 */
@Service
public class SessaoServiceImpl implements SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private PautaServiceImpl pautaServiceImpl;

    /**
     * Criar uma Sessão
     *
     * @param sessaoDto
     * @return
     */
    @Override
    public SessaoVO criarSessao(SessaoDTO sessaoDto) {
        pautaServiceImpl.validar(sessaoDto.getCodePauta());
        Sessao sessaoValida = sessaoRepository.findByInsPauta(sessaoDto.getCodePauta());
        if (sessaoValida != null) {
            throw new NotFoundException("Já existe uma Sessao aberta para essa pauta");
        }
        GregorianCalendar datCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        Sessao sessao = new Sessao();
        sessao.setInsPauta(sessaoDto.getCodePauta());
        sessao.setDatInicio(datCalendar.getTime());
        if (sessaoDto.getMinutosPauta() != null) {
            datCalendar.add(GregorianCalendar.MINUTE, sessaoDto.getMinutosPauta());
        } else {
            datCalendar.add(GregorianCalendar.MINUTE, +1);
        }
        sessao.setDatFim(datCalendar.getTime());
        Sessao retorno = sessaoRepository.saveAndFlush(sessao);
        return new SessaoVO(retorno);
    }

    /**
     * buscar Sessao por codeSessao
     *
     * @param codeSessao
     * @return
     */
    @Override
    public SessaoVO getSessao(Integer codeSessao) {
        Optional<Sessao> sessao = sessaoRepository.findById(codeSessao);
        validar(sessao);
        return new SessaoVO(sessao.get());
    }

    /**
     * validar sessão
     *
     * @param sessao
     */
    @Override
    public void validar(Optional<Sessao> sessao) {
        if (!sessao.isPresent()) {
            throw new NotFoundException("Code Sessao inválido");
        }
        if (sessao.get().getDatFim() != null && sessao.get().getDatFim().before(new Date())) {
            throw new NotFoundException("Sessão de votação expirada");
        }
    }

    /**
     * validar Sessão
     *
     * @param idSessao
     */
    @Override
    public void validar(Integer idSessao) {
        Optional<Sessao> sessao = sessaoRepository.findById(idSessao);
        validar(sessao);
    }

}
