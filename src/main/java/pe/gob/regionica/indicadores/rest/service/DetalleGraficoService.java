package pe.gob.regionica.indicadores.rest.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.DetalleGrafico;
import pe.gob.regionica.indicadores.rest.dao.DetalleGraficoDAO;

@Component
@Transactional
public class DetalleGraficoService {
	
	private DetalleGraficoDAO detalleGraficoDAO;
	
	public DetalleGraficoDAO getDetalleGraficoDAO() {
		return detalleGraficoDAO;
	}

	@Autowired
	public void setDetalleGraficoDAO(DetalleGraficoDAO detalleGraficoDAO) {
		this.detalleGraficoDAO = detalleGraficoDAO;
	}
	
	public DetalleGraficoService(){
		super();
	}
	
	public DetalleGraficoService(DetalleGraficoDAO detalleGraficoDAO){
		this.detalleGraficoDAO = detalleGraficoDAO;
	}

	public DetalleGrafico get(Long codigo) {
		DetalleGrafico detalleGrafico = getDetalleGraficoDAO().get(codigo);
		return detalleGrafico;
	}
	
	public List<DetalleGrafico> getByParent(Long codigo) {
		List<DetalleGrafico> list = getDetalleGraficoDAO().getByParent(codigo);
		return list;
	}

	public List<DetalleGrafico> getByChart(Long codigo) {
		List<DetalleGrafico> list = getDetalleGraficoDAO().getByChart(codigo);
		return list;
	}
	
	public Serializable save(DetalleGrafico detalleGrafico){
		return getDetalleGraficoDAO().save(detalleGrafico);
	}

	public void update(DetalleGrafico detalleGrafico){
		getDetalleGraficoDAO().update(detalleGrafico);
	}
	
	public void delete(DetalleGrafico detalleGrafico){
		getDetalleGraficoDAO().delete(detalleGrafico);
	}
}
