package pe.gob.regionica.indicadores.rest.ws;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.regionica.indicadores.rest.bean.Indicador;
import pe.gob.regionica.indicadores.rest.service.IndicadorService;

@RestController
@RequestMapping(value = "/indicador")
public class IndicadorWS {

	private final Logger log = LoggerFactory.getLogger(IndicadorWS.class);
	
	@Autowired
	private static IndicadorService indicadorService;

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Indicador> list() {
		try{
			List<Indicador> result = indicadorService.list();
			return result;
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return ListUtils.EMPTY_LIST;
	}

	@ResponseBody
	@RequestMapping(value = "/modificar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void modificarIndicador(Indicador indicador){
		
	}

	@ResponseBody
	@RequestMapping(value = "/guardar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void guardarIndicador(Indicador indicador){
		
	}

	@ResponseBody
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarIndicador(Long codigo){
		
	}
}
