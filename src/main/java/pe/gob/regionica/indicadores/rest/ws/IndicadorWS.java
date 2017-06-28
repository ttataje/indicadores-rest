package pe.gob.regionica.indicadores.rest.ws;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;

import pe.gob.regionica.indicadores.rest.bean.Indicador;
import pe.gob.regionica.indicadores.rest.service.IndicadorService;

@Controller
@RequestMapping(value = "/indicador")
public class IndicadorWS {

	private final Logger log = LoggerFactory.getLogger(IndicadorWS.class);

	@Autowired
	private IndicadorService indicadorService;
	
	public IndicadorWS(){
		super();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list")
	@ResponseBody
	public ResponseEntity<List<Indicador>> list() {
		try{
			List<Indicador> result = indicadorService.list();
			return new ResponseEntity<List<Indicador>>(result, HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return new ResponseEntity<List<Indicador>>(ListUtils.EMPTY_LIST, HttpStatus.ACCEPTED);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/get")
	@ResponseBody
	public ResponseEntity<List<Indicador>> get(HttpServletRequest request) {
		try{
			String codigo = request.getParameter("codigo");
			List<Indicador> result = indicadorService.get(StringUtils.isNullOrEmpty(codigo) ? 1 : new Long(codigo));
			return new ResponseEntity<List<Indicador>>(result, HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return new ResponseEntity<List<Indicador>>(ListUtils.EMPTY_LIST, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/modificar")
	@ResponseBody
	public ResponseEntity<Indicador> modificarIndicador(Indicador indicador){
		return new ResponseEntity<Indicador>(indicador, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/guardar")
	@ResponseBody
	public ResponseEntity<Indicador> guardarIndicador(Indicador indicador){
		return new ResponseEntity<Indicador>(indicador, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/eliminar")
	@ResponseBody
	public ResponseEntity<Indicador> eliminarIndicador(Indicador indicador){
		return new ResponseEntity<Indicador>(indicador, HttpStatus.ACCEPTED);
	}
}
