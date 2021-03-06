package pe.gob.regionica.indicadores.rest.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Indicador;
import pe.gob.regionica.indicadores.rest.dao.IndicadorDAO;

@Component
@Transactional
public class IndicadorService {

	private IndicadorDAO indicadorDAO;
	
	public IndicadorDAO getIndicadorDAO() {
		return indicadorDAO;
	}

	@Autowired
	public void setIndicadorDAO(IndicadorDAO indicadorDAO) {
		this.indicadorDAO = indicadorDAO;
	}
	
	public IndicadorService(){
		super();
	}
	
	public IndicadorService(IndicadorDAO indicadorDAO){
		super();
		this.indicadorDAO = indicadorDAO;
	}

	public List<Indicador> list() {
		List<Indicador> list = getIndicadorDAO().list();
		return list;
	}

	public List<Indicador> getByParent(Long codigo) {
		List<Indicador> list = getIndicadorDAO().getByParent(codigo);
		return list;
	}
	
	public Indicador get(Long codigo) {
		return getIndicadorDAO().get(codigo);
	}

	public Serializable save(Indicador indicador){
		return getIndicadorDAO().save(indicador);
	}

	public void update(Indicador indicador){
		getIndicadorDAO().update(indicador);
	}
	
	public void delete(Indicador indicador){
		getIndicadorDAO().delete(indicador);
	}
}
