/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.Exception.MensagemException;
import br.com.jefferson.pautaApi.dto.PautaDTO;
import br.com.jefferson.pautaApi.service.PautaServiceImpl;
import br.com.jefferson.pautaApi.vo.PautaVO;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.web.client.RestClientException;

/**
 *
 * @author jepherson
 */
@RestController
@RequestMapping("pauta")
public class PautaController {

    @Autowired
    private PautaServiceImpl pautaServiceImpl;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaVO> criarPauta(@RequestBody @Valid PautaDTO pautaDto, HttpServletResponse response) throws JsonProcessingException {
        PautaVO pautaVo = pautaServiceImpl.salvarPauta(pautaDto);
        return new ResponseEntity<>(pautaVo, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaVO> getPauta(@PathVariable(name = "code", required = true) Integer code) {
        PautaVO pautaVo = pautaServiceImpl.pesquisarPorCodigo(code);
        if (pautaVo == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pautaVo, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> concluirPauta(@PathVariable(name = "code", required = true) Integer code) {
        PautaVO pautaVo = pautaServiceImpl.concluirPauta(code);
        return new ResponseEntity<>(pautaVo, HttpStatus.OK);
    }

}
