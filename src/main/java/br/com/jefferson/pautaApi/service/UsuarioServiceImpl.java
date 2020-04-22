/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.enuns.UsuarioStatusEnum;
import br.com.jefferson.pautaApi.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jepherson
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Value("${url.user}")
    private String url;

    @Override
    public UsuarioVO validarCPF(String cpf) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            UsuarioVO retorno = restTemplate.getForObject(url.concat(cpf), UsuarioVO.class);
            return retorno;

        } catch (HttpClientErrorException ex) {
            return new UsuarioVO(UsuarioStatusEnum.UNABLE_TO_VOTO.name());
        }
    }

}
