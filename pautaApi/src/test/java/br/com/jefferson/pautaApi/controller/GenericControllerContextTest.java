package br.com.jefferson.pautaApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author jefferson
 */
public abstract class GenericControllerContextTest {
    
       public String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
