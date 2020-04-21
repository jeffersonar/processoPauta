///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.jefferson.pautaApi.controller;
//
//import br.com.jefferson.pautaApi.dto.PautaDTO;
//import br.com.jefferson.pautaApi.service.PautaServiceImpl;
//import br.com.jefferson.pautaApi.vo.PautaVO;
//import java.util.Date;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import static org.mockito.Mockito.when;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// *
// * @author jefferson
// */
//@ExtendWith(SpringExtension.class)
//@WebMvcTest
//public class PautaControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    private PautaServiceImpl pautaServiceImpl;
//
//    /**
//     * Pesquisar por id pauta
//     * @path /pauta/code
//     * @Response PautaVO
//     * @Status 200
//     * @throws Exception
//     */
//    @Test
//    void getPautaPesquisarIdValido() throws Exception {
//        PautaVO pautaVo = new PautaVO();
//        pautaVo.setCodePauta(1);
//        pautaVo.setDataCadastro(new Date());
//        pautaVo.setDescricao("Teste 123");
//        when(pautaServiceImpl.pesquisarPorCodigo(1)).thenReturn(pautaVo);
//        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/pauta/1")
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isOk())
//                .andReturn().getResponse();
//    }
//    
//    /**
//     * Pesquisar por id pauta invalido 
//     * @path /pauta/code
//     * @Response PautaVO
//     * @Status 204
//     * @throws Exception 
//     */
//    @Test
//    void getPautaPesquisarIdInvalido() throws Exception {
//        PautaVO pautaVo = new PautaVO();
//        pautaVo.setCodePauta(1);
//        pautaVo.setDataCadastro(new Date());
//        pautaVo.setDescricao("Teste 123");
//        when(pautaServiceImpl.pesquisarPorCodigo(1)).thenReturn(pautaVo);
//        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/pauta/66")
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isNoContent())
//                .andReturn().getResponse();
//    }
//
//    /**
//     * Pesquisar por url invalida get
//     * @path /pauta/code
//     * @Response PautaVO
//     * @Status 404
//     * @throws Exception 
//     */
//    @Test
//    void getPautaPesquisarNull() throws Exception {
//        PautaVO pautaVo = new PautaVO();
//        pautaVo.setCodePauta(1);
//        pautaVo.setDataCadastro(new Date());
//        pautaVo.setDescricao("Teste 123");
//        when(pautaServiceImpl.pesquisarPorCodigo(1)).thenReturn(pautaVo);
//        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/pauta/")
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(status().isMethodNotAllowed())
//                .andReturn().getResponse();
//    }
//
//    /**
//     * Criar uma nova pauta
//     * @path /pauta
//     * @method post
//     * @Response PautaVO
//     * @Status 201
//     * @throws Exception 
//     */
//    @Test
//    void cadastrarNovaOk () throws Exception{
//        PautaDTO pautaDto = new PautaDTO();
//        pautaDto.setDescricao("teste");
//        PautaVO pautaVo = new PautaVO();
//        pautaVo.setCodePauta(1);
//        pautaVo.setDataCadastro(new Date());
//        pautaVo.setDescricao("teste");
//        when(pautaServiceImpl.salvarPauta(pautaDto)).thenReturn(pautaVo);
//        
//        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/pauta")
//                .contentType(MediaType.APPLICATION_JSON).content("{\"descricao\":\"teste\"}"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isCreated())
//                .andReturn().getResponse();
//        
//    }
// 
//    /**
//     * Criar uma nova pauta com a descrição vazio
//     * @path /pauta
//     * @method post
//     * @Response PautaVO
//     * @Status 400
//     * @throws Exception 
//     */
//    @Test
//    void cadastrarNovaValidarDescricao () throws Exception{
//        PautaDTO pautaDto = new PautaDTO();
//        pautaDto.setDescricao("");
//        when(pautaServiceImpl.salvarPauta(pautaDto)).thenReturn(null);
//        
//        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/pauta")
//                .contentType(MediaType.APPLICATION_JSON).content("{\"descricao\":\"\"}"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isBadRequest())
//                .andReturn().getResponse();
//        
//    }
//    
//      /**
//     * concluir uma pauta
//     * @path /pauta
//     * @method post
//     * @Response PautaVO
//     * @Status 200
//     * @throws Exception 
//     */
//    @Test
//    void concluirPauta () throws Exception{
//        PautaVO pautaVo = new PautaVO();
//        pautaVo.setCodePauta(1);
//        pautaVo.setDataCadastro(new Date());
//        pautaVo.setDescricao("teste");
//        pautaVo.setDataConclusao(new Date());
//        when(pautaServiceImpl.concluirPauta(1)).thenReturn(pautaVo);
//        
//        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.put("/pauta/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isOk())
//                .andReturn().getResponse();
//        
//    }
//}
