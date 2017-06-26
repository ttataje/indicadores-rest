package pe.gob.regionica.indicadores.rest.ws;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.gob.regionica.indicadores.rest.bean.Grafico;
import pe.gob.regionica.indicadores.rest.service.GraficoService;

@Controller
@RequestMapping(value = "/grafico")
public class GraficoWS {

	private final Logger log = LoggerFactory.getLogger(GraficoWS.class);
	
	private static GraficoService graficoService;
	
	public GraficoWS(){
		super();
		graficoService = new GraficoService();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list")
	@ResponseBody
	public ResponseEntity<List<Grafico>> list() {
		List<Grafico> result = ListUtils.EMPTY_LIST;
		try{
			result = graficoService.list();
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<List<Grafico>>(result, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Grafico>>(result, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/cargar")
	@ResponseBody
	public ResponseEntity<Grafico> cargarGrafico(@RequestParam("codigo") Long codigo){
		Grafico grafico = null;
		try{
			grafico = graficoService.get(codigo);
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<Grafico>(grafico, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Grafico>(grafico, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/modificar")
	@ResponseBody
	public ResponseEntity<Grafico> modificarGrafico(Grafico grafico){
		return new ResponseEntity<Grafico>(grafico, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/guardar")
	@ResponseBody
	public ResponseEntity<Grafico> guardarGrafico(Grafico grafico){
		return new ResponseEntity<Grafico>(grafico, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/eliminar")
	@ResponseBody
	public ResponseEntity<Grafico> eliminarGrafico(Grafico grafico){
		return new ResponseEntity<Grafico>(grafico, HttpStatus.ACCEPTED);
	}
}
