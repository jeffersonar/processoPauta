package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.controller.VotacaoControllerContextTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author jefferson
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {VotacaoServiceImpl.class})
public class VotacaoServiceImplTest extends VotacaoControllerContextTest{
    
}
