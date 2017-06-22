package pe.gob.regionica.indicadores.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Indicador;

@Service
@Transactional(readOnly=true)
public class IndicadorService extends GenericService {

	public List<Indicador> list() {
		List<Indicador> list = getSession().createQuery("from Indicador").getResultList();
		return list;
	}

	@Transactional(readOnly=false)
	public void save(Indicador indicador){
		getSession().persist(indicador);
	}

	@Transactional(readOnly=false)
	public void update(Indicador indicador){
		getSession().update(indicador);
	}
	
	@Transactional(readOnly=false)
	public void delete(Indicador indicador){
		getSession().delete(indicador);
	}
}
