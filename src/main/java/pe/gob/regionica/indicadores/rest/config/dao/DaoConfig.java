package pe.gob.regionica.indicadores.rest.config.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pe.gob.regionica.indicadores.rest.dao.ColorDAO;
import pe.gob.regionica.indicadores.rest.dao.GraficoDAO;
import pe.gob.regionica.indicadores.rest.dao.IndicadorDAO;

@Configuration
@EnableTransactionManagement
public class DaoConfig {

	@Autowired
	@Bean(name = "colorDAO")
	public ColorDAO getColorDAO(SessionFactory sessionFactory){
		return new ColorDAO(sessionFactory);
	}

	@Autowired
	@Bean(name = "graficoDAO")
	public GraficoDAO getGraficoDAO(SessionFactory sessionFactory){
		return new GraficoDAO(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "indicadorDAO")
	public IndicadorDAO getIndicadorDAO(SessionFactory sessionFactory){
		return new IndicadorDAO(sessionFactory);
	}

}
