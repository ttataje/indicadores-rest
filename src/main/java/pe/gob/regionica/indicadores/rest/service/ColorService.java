package pe.gob.regionica.indicadores.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Color;
import pe.gob.regionica.indicadores.rest.dao.ColorDAO;

@Component
@Transactional
public class ColorService {

	private ColorDAO colorDAO;

	public ColorDAO getColorDAO() {
		return colorDAO;
	}

	@Autowired
	public void setColorDAO(ColorDAO colorDAO) {
		this.colorDAO = colorDAO;
	}
	
	public ColorService(){
		super();
	}

	public ColorService(ColorDAO colorDAO){
		super();
		this.colorDAO = colorDAO;
	}

	public List<Color> list() {
		List<Color> list = getColorDAO().list();
		return list;
	}
	
	
}
