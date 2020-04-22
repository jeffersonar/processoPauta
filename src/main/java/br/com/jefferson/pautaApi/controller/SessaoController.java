package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.dto.SessaoDTO;
import br.com.jefferson.pautaApi.service.SessaoServiceImpl;
import br.com.jefferson.pautaApi.vo.SessaoVO;
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
 * Endpoint Sessao
 * @path /sessao
 * @author jefferson
 */
@RestController
@RequestMapping("sessao")
public class SessaoController {

    @Autowired
    private SessaoServiceImpl sessaoServiceImpl;

    /**
     * Criar uma nova Sessão por pauta
     * @param sessaoDto
     * @param response
     * @return ResponseEntity<SessaoVO>
     * @Status HttpStatus.CREATED
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessaoVO> criarSessao(@RequestBody @Valid SessaoDTO sessaoDto,
            HttpServletResponse response) {
        SessaoVO sessaoVo = sessaoServiceImpl.criarSessao(sessaoDto);
        return new ResponseEntity<>(sessaoVo, HttpStatus.CREATED);

    }

    /**
     * buscar Sessao por codeSessao
     * @param code
     * @return ResponseEntity<SessaoVO>
     * @Status HttpStatus.OK
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{codeSessao}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessaoVO> getSessao(@PathVariable(name = "codeSessao", required = true) Integer code) {
        SessaoVO sessaoVo = sessaoServiceImpl.getSessao(code);
        return new ResponseEntity<>(sessaoVo, HttpStatus.OK);

    }

}
