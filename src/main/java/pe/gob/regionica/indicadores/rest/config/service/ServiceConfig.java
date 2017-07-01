package pe.gob.regionica.indicadores.rest.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.gob.regionica.indicadores.rest.dao.ColorDAO;
import pe.gob.regionica.indicadores.rest.dao.DetalleGraficoDAO;
import pe.gob.regionica.indicadores.rest.dao.GraficoDAO;
import pe.gob.regionica.indicadores.rest.dao.IndicadorDAO;
import pe.gob.regionica.indicadores.rest.service.ColorService;
import pe.gob.regionica.indicadores.rest.service.DetalleGraficoService;
import pe.gob.regionica.indicadores.rest.service.GraficoService;
import pe.gob.regionica.indicadores.rest.service.IndicadorService;

@Configuration
public class ServiceConfig {

	@Autowired
	@Bean(name = "colorService")
	public ColorService getColorService(ColorDAO colorDAO){
		return new ColorService(colorDAO);
	}

	@Autowired
	@Bean(name = "graficoService")
	public GraficoService getGraficoService(GraficoDAO graficoDAO){
		return new GraficoService(graficoDAO);
	}
	
	@Autowired
	@Bean(name = "indicadorService")
	public IndicadorService getIndicadorService(IndicadorDAO indicadorDAO){
		return new IndicadorService(indicadorDAO);
	}

	@Autowired
	@Bean(name = "detalleGraficoService")
	public DetalleGraficoService getDetalleGraficoService(DetalleGraficoDAO detalleGraficoDAO){
		return new DetalleGraficoService(detalleGraficoDAO);
	}
}
