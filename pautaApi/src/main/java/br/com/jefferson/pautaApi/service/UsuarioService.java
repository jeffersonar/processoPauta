package br.com.jefferson.pautaApi.service;

import br.com.jefferson.pautaApi.vo.UsuarioVO;

/**
 *
 * @author jefferson
 */
public interface UsuarioService {
    
    public UsuarioVO validarCPF(String cpf);
    
}
