package pe.gob.regionica.indicadores.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Color;

@Service
@Transactional(readOnly=true)
public class ColorService extends GenericService {

	public List<Color> list() {
		List<Color> list = getSession().createQuery("from Color").getResultList();
		return list;
	}
}
