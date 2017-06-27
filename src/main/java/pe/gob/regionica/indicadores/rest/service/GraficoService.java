package pe.gob.regionica.indicadores.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Grafico;
import pe.gob.regionica.indicadores.rest.dao.GraficoDAO;

@Component
@Transactional
public class GraficoService {
	
	private GraficoDAO graficoDAO;
	
	public GraficoDAO getGraficoDAO() {
		return graficoDAO;
	}

	@Autowired
	public void setGraficoDAO(GraficoDAO graficoDAO) {
		this.graficoDAO = graficoDAO;
	}
	
	public GraficoService(){
		super();
	}
	
	public GraficoService(GraficoDAO graficoDAO){
		this.graficoDAO = graficoDAO;
	}

	public List<Grafico> list() {
		List<Grafico> list = getGraficoDAO().list();
		return list;
	}

	public Grafico get(Long id) {
		Grafico grafico = getGraficoDAO().get(id);
		return grafico;
	}

	public void save(Grafico grafico){
		getGraficoDAO().save(grafico);
	}

	public void update(Grafico grafico){
		getGraficoDAO().update(grafico);
	}
	
	public void delete(Grafico grafico){
		getGraficoDAO().delete(grafico);
	}
}
