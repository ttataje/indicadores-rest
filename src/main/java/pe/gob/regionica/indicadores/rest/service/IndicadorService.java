package pe.gob.regionica.indicadores.rest.service;

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
	
	public List<Indicador> get(Long codigo) {
		List<Indicador> list = getIndicadorDAO().get(codigo);
		return list;
	}

	public void save(Indicador indicador){
		getIndicadorDAO().save(indicador);
	}

	public void update(Indicador indicador){
		getIndicadorDAO().update(indicador);
	}
	
	public void delete(Indicador indicador){
		getIndicadorDAO().delete(indicador);
	}
}
