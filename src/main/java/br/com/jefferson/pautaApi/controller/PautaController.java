package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.dto.PautaDTO;
import br.com.jefferson.pautaApi.service.PautaServiceImpl;
import br.com.jefferson.pautaApi.vo.PautaVO;
import br.com.jefferson.pautaApi.vo.ResultadoPautaVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
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
 * Endpoint Pauta
 * @path /pauta
 * @author jefferson
 */
@RestController
@RequestMapping("pauta")
public class PautaController {

    @Autowired
    private PautaServiceImpl pautaServiceImpl;

    /**
     * Criar uma nova Pauta
     * @param pautaDto
     * @param response
     * @return ResponseEntity<PautaVO>
     * @Status HttpStatus.CREATED
     * @throws JsonProcessingException 
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaVO> criarPauta(@RequestBody @Valid PautaDTO pautaDto, HttpServletResponse response) throws JsonProcessingException {
        PautaVO pautaVo = pautaServiceImpl.salvarPauta(pautaDto);
        return new ResponseEntity<>(pautaVo, HttpStatus.CREATED);

    }

    /**
     * buscarPauta por codePauta
     * @param code
     * @return ResponseEntity<PautaVO>
     * @Status HttpStatus.OK
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{codePauta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PautaVO> getPauta(@PathVariable(name = "codePauta", required = true) Integer code) {
        PautaVO pautaVo = pautaServiceImpl.pesquisarPorCodigo(code);
        return new ResponseEntity<>(pautaVo, HttpStatus.OK);
    }

    /**
     * Resultado da votação por pauta
     * @param code
     * @return ResponseEntity<PautaVO>
     * @Status HttpStatus.OK
     */
    @RequestMapping(method = RequestMethod.GET, path = "/resultado/{codePauta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResultadoPautaVO> > countVotacao(@PathVariable(name = "codePauta", required = true) Integer code) {
        List<ResultadoPautaVO>  resultadoPautaVO = pautaServiceImpl.resultadoPauta(code);
        return new ResponseEntity<>(resultadoPautaVO, HttpStatus.OK);
    }

    
}
