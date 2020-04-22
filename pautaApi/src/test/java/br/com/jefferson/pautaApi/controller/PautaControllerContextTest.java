package br.com.jefferson.pautaApi.controller;

import br.com.jefferson.pautaApi.dto.PautaDTO;
import br.com.jefferson.pautaApi.vo.PautaVO;
import br.com.jefferson.pautaApi.vo.ResultadoPautaVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jefferson
 */
public abstract class PautaControllerContextTest extends GenericControllerContextTest {

    public PautaVO getPautaVO() {
        PautaVO pautaVo = new PautaVO();
        pautaVo.setCodePauta(1);
        pautaVo.setDataCadastro("13/01/1993 08:53:12");
        pautaVo.setDescricao("Teste 123");
        return pautaVo;
    }

    public PautaDTO getPautaDTO() {
        PautaDTO pautaDto = new PautaDTO();
        pautaDto.setDescricao("descricao");
        return pautaDto;
    }
    
    public PautaDTO getPautaDTOIncorreto() {
        PautaDTO pautaDto = new PautaDTO();
        pautaDto.setDescricao("");
        return pautaDto;
    }
    
    public List<ResultadoPautaVO> getResultadoPautaVO(){
        List<ResultadoPautaVO> retorno = new ArrayList<>();
        retorno.add(new ResultadoPautaVO(1,1,true,154l));
        retorno.add(new ResultadoPautaVO(1,1,false,5254l));
        return retorno;
    }
}
