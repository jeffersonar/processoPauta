/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.Exception.BadRequestException;
import br.com.jefferson.pautaApi.dto.VotacaoDTO;
import br.com.jefferson.pautaApi.service.VotacaoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author jefferson
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(VotacaoController.class)
public class VotacaoControllerTest extends VotacaoControllerContextTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private VotacaoServiceImpl votacaoServiceImpl;

    
    /**
     * @Cenario Salvar um novo voto
     * @Dado json esteja preenchido incorretamente
     * @Quando envio do json via post
     * @Entao o status do retorno do endpoint devera ser 400 - Bad Request
     */
    @Test
    public void votarIncorreto() throws Exception {
        Integer codeSessao=1;
        
        when(votacaoServiceImpl.votar(codeSessao,getVotacaoDTOVazio())).thenReturn(getVotacaoVO());
        
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/votacao/".concat(codeSessao.toString()))
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getVotacaoDTOVazio())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn().getResponse();
    }
    
    
    /**
     * @Cenario Salvar um novo voto
     * @Dado json esteja preenchido corretamente
     * @Quando envio do json via post
     * @Entao o status do retorno do endpoint devera ser 201 - Created
     */
    @Test
    public void votar() throws Exception {
        Integer codeSessao=1;
        
        when(votacaoServiceImpl.votar(any(Integer.class),any(VotacaoDTO.class))).thenReturn(getVotacaoVO());
        
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/votacao/".concat(codeSessao.toString()))
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getVotacaoDTO())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn().getResponse();
    }
    
}
