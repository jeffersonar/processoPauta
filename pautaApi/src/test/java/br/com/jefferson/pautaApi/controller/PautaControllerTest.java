package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.Exception.NoContentException;
import br.com.jefferson.pautaApi.service.PautaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author jefferson
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(PautaController.class)
public class PautaControllerTest extends PautaControllerContextTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PautaServiceImpl pautaServiceImpl;

    /**
     * @Cenario Salvar uma nova Pauta
     * @Dado json esteja preenchido corretamente
     * @Quando envio do json via post
     * @Entao o status do retorno do endpoint devera ser 201 - created
     */
    @Test
    public void criarNovaPauta() throws Exception {
        when(pautaServiceImpl.salvarPauta(getPautaDTO())).thenReturn(getPautaVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/pauta")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getPautaVO())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn().getResponse();
    }

    /**
     * @Cenario salvar uma pauta sem descrição
     * @Dado json não esteja preenchido com a descrição
     * @Quando envio do json seja via post
     * @Entao o status do retorno do endpoint devera ser 400 - Bad Request
     */
    @Test
    public void criaNoavaPautaIncorreta() throws Exception {
        when(pautaServiceImpl.salvarPauta(getPautaDTO())).thenReturn(getPautaVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.post("/pauta")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getPautaDTOIncorreto())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn().getResponse();
    }

    /**
     * @Cenario Buscar por codePauta
     * @Dado code da pauta for incorreto
     * @Quando acessar a url /pauta/{codePauta}
     * @Entao o status do retorno do endpoint devera ser 400 - Bad Request
     */
    @Test
    public void buscarPorPauta() throws Exception {
        when(pautaServiceImpl.pesquisarPorCodigo(1)).thenReturn(getPautaVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/pauta/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getPautaDTOIncorreto())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

    /**
     * @Cenario Buscar por codePauta
     * @Dado code da pauta for correto
     * @Quando acessar a url /pauta/{codePauta}
     * @Entao o status do retorno do endpoint devera ser 200 - ok
     */
    @Test
    public void buscarPorPautaIncorreto() throws Exception {
        when(pautaServiceImpl.pesquisarPorCodigo(1)).thenThrow(new NoContentException("Não existe pauta com esse code"));
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/pauta/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getPautaDTOIncorreto())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent())
                .andReturn().getResponse();
    }

    /**
     * @Cenario Resultado por codePauta
     * @Dado code da pauta for correto
     * @Quando acessar a url /pauta/resultado/{codePauta}
     * @Entao o status do retorno do endpoint devera ser 200 - ok
     */
    @Test
    public void resultadoPorCodePauta() throws Exception {
        when(pautaServiceImpl.resultadoPauta(1)).thenReturn(getResultadoPautaVO());
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/pauta/resultado/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

    /**
     * @Cenario Resultado por codePauta
     * @Dado code da pauta for inCorreto
     * @Quando acessar a url /pauta/resultado/{codePauta}
     * @Entao o status do retorno do endpoint devera ser 400 - Bad Request
     */
    @Test
    public void resultadoPorCodePautaIncorreto() throws Exception {
        when(pautaServiceImpl.resultadoPauta(1)).thenThrow(new NoContentException("Não existe voto nesta pauta"));
        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(MockMvcRequestBuilders.get("/pauta/resultado/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent())
                .andReturn().getResponse();
    }
}
