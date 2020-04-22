package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.Exception.NoContentException;
import br.com.jefferson.pautaApi.repository.SessaoRepository;
import br.com.jefferson.pautaApi.vo.PautaVO;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
@SpringBootTest(classes = {SessaoServiceImpl.class})
public class SessaoServiceImplTest extends SessaoServiceImplContextTest {

    @Autowired
    private SessaoServiceImpl sessaoServiceImpl;

    @MockBean
    private SessaoRepository sessaoRepository;

    @MockBean
    private PautaServiceImpl pautaServiceImpl;


}
