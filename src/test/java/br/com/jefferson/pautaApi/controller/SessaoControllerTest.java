/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.service.SessaoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
@WebMvcTest(SessaoController.class)
public class SessaoControllerTest extends SessaoControllerContextTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private SessaoServiceImpl sessaoServiceImpl;

    
    /**
     * @Cenario Salvar uma nova sessao
     * @Dado json esteja preenchido corretamente
     * @Quando envio do json via post
     * @Entao o status do retorno do endpoint devera ser 201 - created
     */
    @Test
    public void criarNovaSessao() throws Exception {
        when(sessaoServiceImpl.criarSessao(getSessaoDTO())).thenReturn(getSessaoVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/sessao")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getSessaoDTO())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn().getResponse();
    }
    
    
    /**
     * @Cenario Salvar uma nova sessao 
     * @Dado json esteja preenchido incorreto
     * @Quando envio do json via post
     * @Entao o status do retorno do endpoint devera ser 400 - Bad Request
     */
    @Test
    public void criarNovaSessaoIncorreto() throws Exception {
        when(sessaoServiceImpl.criarSessao(getSessaoDTOIncorreto())).thenReturn(getSessaoVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/sessao")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getSessaoDTOIncorreto())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn().getResponse();
    }
    
    /**
     * @Cenario Buscar por codeSessao
     * @Dado code da pauta for correto
     * @Quando acessar a url /sessao/{codeSesso}
     * @Entao o status do retorno do endpoint devera ser 200 - Ok
     */
    @Test
    public void buscarPorPauta() throws Exception {
        when(sessaoServiceImpl.getSessao(1)).thenReturn(getSessaoVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/sessao/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

    /**
     * @Cenario Buscar por codeSessao
     * @Dado code da pauta for incorreto
     * @Quando acessar a url /sessao/{codeSesso}
     * @Entao o status do retorno do endpoint devera ser 200 - Ok
     */
    @Test
    public void buscarPorPautaIncorreto() throws Exception {
        when(sessaoServiceImpl.getSessao(1)).thenReturn(getSessaoVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/sessao/4")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }
    
    
    
    
}
