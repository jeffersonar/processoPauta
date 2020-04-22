package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.dto.VotacaoDTO;
import br.com.jefferson.pautaApi.service.VotacaoServiceImpl;
import br.com.jefferson.pautaApi.vo.VotacaoVO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint votacao
 * @path /votacao
 * @author jefferson
 */
@RestController
@RequestMapping("votacao")
public class VotacaoController {

    @Autowired
    private VotacaoServiceImpl votacaoServiceImpl;

    /**
     * votar por sessão
     * @param codeSessao
     * @param votacaoDto
     * @param response
     * @Status HttpStatus.CREATED
     * @return ResponseEntity<VotacaoVO>
     */
    @RequestMapping(method = RequestMethod.POST, path = "/{codeSessao}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VotacaoVO> votar(@PathVariable(name = "codeSessao", required = true) Integer codeSessao,
                                                                        @RequestBody @Valid VotacaoDTO votacaoDto, 
                                                                                     HttpServletResponse response) {
        VotacaoVO votacao = votacaoServiceImpl.votar(codeSessao, votacaoDto);
        return new ResponseEntity<>(votacao, HttpStatus.CREATED);

    }

}
