package pe.gob.regionica.indicadores.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Indicador;

@Service
@Transactional(readOnly=true)
public class IndicadorService extends GenericService {

	public List<Indicador> list() {
		return null;
	}
}
