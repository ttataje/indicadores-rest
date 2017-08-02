package pe.gob.regionica.indicadores.rest.config.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pe.gob.regionica.indicadores.rest.dao.DetalleGraficoDAO;
import pe.gob.regionica.indicadores.rest.dao.GraficoDAO;
import pe.gob.regionica.indicadores.rest.dao.IndicadorDAO;

@Configuration
@EnableTransactionManagement
public class DaoConfig {

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

	@Autowired
	@Bean(name = "detalleGraficoDAO")
	public DetalleGraficoDAO getDetalleGraficoDAO(SessionFactory sessionFactory){
		return new DetalleGraficoDAO(sessionFactory);
	}
}
