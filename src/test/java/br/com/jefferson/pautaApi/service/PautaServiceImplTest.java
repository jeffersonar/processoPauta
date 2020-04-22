package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.Exception.NoContentException;
import br.com.jefferson.pautaApi.entity.Pauta;
import br.com.jefferson.pautaApi.repository.PautaRepository;
import br.com.jefferson.pautaApi.vo.PautaVO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author jefferson
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PautaServiceImpl.class})
public class PautaServiceImplTest extends PautaServiceImplContextTest {

    @Autowired
    private PautaServiceImpl pautaServiceImpl;

    @MockBean
    private PautaRepository pautaRepository;

    /**
     * @Cenario Salvar Pauta
     * @Dado PautaDTO seja preenchido corretamente
     * @Quando salvar no banco de dados
     * @Entao metodo devera retorna PautaVO
     */
    @Test
    public void salvarPauta() {
        when(pautaRepository.saveAndFlush(any(Pauta.class))).thenReturn(getPautaSalvar());
        assertEquals(pautaServiceImpl.salvarPauta(getPautaDTO()).getCodePauta(), new PautaVO(getPautaSalvar()).getCodePauta());
    }

    /**
     * @Cenario pesquisar por codiPauta invalido
     * @Dado receber codePauta como parametro
     * @Entao metodo devera retorna PautaVO
     */
    @Test
    public void pesquisarPorCodigoIncorreto() {
        when(pautaRepository.findById(1)).thenReturn(getOptionalPautaVazio());
        Exception exception = assertThrows(NoContentException.class, () -> {
            pautaServiceImpl.pesquisarPorCodigo(1);
        });
        String expectedMessage = "Não existe pauta com esse code";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    
    /**
     * @Cenario pesquisar por codiPauta
     * @Dado receber codePauta como parametro
     * @Entao metodo devera retorna PautaVO
     */
    @Test
    public void pesquisarPorCodigo() {
        when(pautaRepository.findById(1)).thenReturn(getOptionalPautaSalvar());
        assertEquals(pautaServiceImpl.pesquisarPorCodigo(1).getCodePauta(), new PautaVO(getOptionalPautaSalvar().get()).getCodePauta());
    }
    
    
    /**
     * @Cenario resultado por codiPauta invalido
     * @Dado receber codePauta como parametro
     * @Entao metodo devera retorna PautaVO
     */
    @Test
    public void resultadoPorCodigoIncorreto() {
        when(pautaRepository.resultadoPauta(1)).thenReturn(getResultadoPautaVOVazio());
        Exception exception = assertThrows(NoContentException.class, () -> {
            pautaServiceImpl.resultadoPauta(1);
        });
        String expectedMessage = "Não existe voto nesta pauta";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    
    
    /**
     * @Cenario resultado por codiPauta invalido
     * @Dado receber codePauta como parametro
     * @Entao metodo devera retorna PautaVO
     */
    @Test
    public void resultadoPorCodigo() {
        when(pautaRepository.resultadoPauta(1)).thenReturn(getResultadoPautaVO());
        assertEquals(pautaServiceImpl.resultadoPauta(1).size(), getResultadoPautaVO().size());
    }
}
