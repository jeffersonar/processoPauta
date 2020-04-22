package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.Exception.AcceptedException;
import br.com.jefferson.pautaApi.Exception.BadRequestException;
import br.com.jefferson.pautaApi.Exception.NotFoundException;
import br.com.jefferson.pautaApi.dto.VotacaoDTO;
import br.com.jefferson.pautaApi.entity.Votacao;
import br.com.jefferson.pautaApi.enuns.UsuarioStatusEnum;
import br.com.jefferson.pautaApi.repository.VotacaoRepository;
import br.com.jefferson.pautaApi.vo.UsuarioVO;
import br.com.jefferson.pautaApi.vo.VotacaoVO;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Camada de regra de negocio
 * @author jefferson
 */
@Service
public class VotacaoServiceImpl implements VotacaoService {

    @Autowired
    private SessaoServiceImpl sessaoServiceImpl;

    @Autowired
    private VotacaoRepository votacaoRepository;
    
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    /**
     * votar por pauta
     * @param isnSessao
     * @param votacaoDto
     * @return 
     */
    @Override
    public VotacaoVO votar(Integer isnSessao, VotacaoDTO votacaoDto) {
        sessaoServiceImpl.validar(isnSessao);
        validar(votacaoDto);
        Votacao votacaoValida = votacaoRepository.findByIsnSessaoAndCpf(isnSessao,votacaoDto.getCpf());
        if(votacaoValida!=null){
            throw new AcceptedException("Um voto por Pauta");
            
        }
        Votacao votacao = new Votacao();
        votacao.setDatCadastro(new Date());
        votacao.setIsnSessao(isnSessao);
        votacao.setCpf(votacaoDto.getCpf());
        votacao.setVoto(votacaoDto.getVoto().trim().equals("Sim"));
        Votacao retorno = votacaoRepository.saveAndFlush(votacao);
        return new VotacaoVO(retorno);
    }

    /**
     * Validar votacao
     * @param votacaoDto 
     */
    @Override
    public void validar(VotacaoDTO votacaoDto) {
        if(!(votacaoDto.getVoto().trim().equals("Sim") || votacaoDto.getVoto().trim().equals("Não"))){
            throw new BadRequestException("Voto inválido (entrada válida Sim/Não)");
        }
        UsuarioVO usuario = usuarioServiceImpl.validarCPF(votacaoDto.getCpf());
        if(usuario.getStatus().equals(UsuarioStatusEnum.UNABLE_TO_VOTO.name())){
            throw new NotFoundException("CPF invalido");
        }
    }

}
