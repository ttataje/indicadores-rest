package pe.gob.regionica.indicadores.rest.ws;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.regionica.indicadores.rest.bean.Grafico;
import pe.gob.regionica.indicadores.rest.service.GraficoService;

@RestController
@RequestMapping(value = "/grafico")
public class GraficoWS {

	private final Logger log = LoggerFactory.getLogger(GraficoWS.class);
	
	@Autowired
	private static GraficoService graficoService;

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Grafico> list() {
		try{
			List<Grafico> result = graficoService.list();
			return result;
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return ListUtils.EMPTY_LIST;
	}

	@ResponseBody
	@RequestMapping(value = "/modificar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void modificarGrafico(Grafico Grafico){
		
	}

	@ResponseBody
	@RequestMapping(value = "/guardar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void guardarGrafico(Grafico Grafico){
		
	}

	@ResponseBody
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarGrafico(Long codigo){
		
	}
}
