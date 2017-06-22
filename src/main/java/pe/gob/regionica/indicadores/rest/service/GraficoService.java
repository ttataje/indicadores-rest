package pe.gob.regionica.indicadores.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Grafico;

@Service
@Transactional(readOnly=true)
public class GraficoService extends GenericService {

	public List<Grafico> list() {
		List<Grafico> list = getSession().createQuery("from Grafico as g ORDER BY g.descripcion").getResultList();
		return list;
	}

	@Transactional(readOnly=false)
	public void save(Grafico grafico){
		getSession().persist(grafico);
	}

	@Transactional(readOnly=false)
	public void update(Grafico grafico){
		getSession().update(grafico);
	}
	
	@Transactional(readOnly=false)
	public void delete(Grafico grafico){
		getSession().delete(grafico);
	}
}
