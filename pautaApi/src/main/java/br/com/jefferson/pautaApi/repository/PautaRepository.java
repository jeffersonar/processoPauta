package br.com.jefferson.pautaApi.repository;

import br.com.jefferson.pautaApi.entity.Pauta;
import br.com.jefferson.pautaApi.vo.ResultadoPautaVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Camada de persistencia
 * @author jefferson
 */
@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer>{
    
    @Query(value="select new br.com.jefferson.pautaApi.vo.ResultadoPautaVO(p.isnPauta,s.isnSessao,v.voto,count(v.isnVotacao)) from Votacao v inner join v.sessao s inner join  s.pauta p where p.isnPauta=?1 group by p.isnPauta,s.isnSessao,v.voto")
    public List<ResultadoPautaVO> resultadoPauta(Integer isnPauta);
    
}
