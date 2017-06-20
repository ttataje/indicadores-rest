package pe.gob.regionica.indicadores.rest.service;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.regionica.indicadores.rest.bean.Grafico;

@Service
@Transactional(readOnly=true)
public class GraficoService extends GenericService {

	public List<Grafico> list() {
		//Session session = this.sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		
		return null;
	}

	
}
