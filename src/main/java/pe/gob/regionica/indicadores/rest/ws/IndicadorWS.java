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
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public ResponseEntity<Indicador> get(HttpServletRequest request) {
		try{
			String codigo = request.getParameter("codigo");
			Indicador result = indicadorService.get(StringUtils.isEmpty(codigo) ? null : new Long(codigo));
			return new ResponseEntity<Indicador>(result, HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return new ResponseEntity<Indicador>((Indicador)null, HttpStatus.ACCEPTED);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getByParent")
	@ResponseBody
	public ResponseEntity<List<Indicador>> getByParent(HttpServletRequest request) {
		try{
			String codigo = request.getParameter("codigo");
			List<Indicador> result = indicadorService.getByParent(StringUtils.isEmpty(codigo) ? null : new Long(codigo));
			return new ResponseEntity<List<Indicador>>(result, HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return new ResponseEntity<List<Indicador>>(ListUtils.EMPTY_LIST, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/modificar")
	@ResponseBody
	public ResponseEntity<Indicador> modificarIndicador(HttpServletRequest request, ModelMap model){
		Indicador indicador = indicadorService.get(new Long(request.getParameter("indicador.codigo")));
		indicador.setDescripcion(request.getParameter("indicador.descripcion"));
		indicador.setPadre(new Long(request.getParameter("indicador.padre.codigo")));
		indicador.setTipo(request.getParameter("indicador.tipo"));
		indicador.setPosition(new Long(request.getParameter("indicador.position")));
		return new ResponseEntity<Indicador>(indicador, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/guardar")
	@ResponseBody
	public ResponseEntity<Long> guardarIndicador(HttpServletRequest request, ModelMap model){
		try{
			Indicador indicador = new Indicador();
			indicador.setDescripcion(request.getParameter("indicador.descripcion"));
			indicador.setPadre(new Long(request.getParameter("indicador.padre.codigo")));
			indicador.setTipo(request.getParameter("indicador.tipo"));
			indicador.setPosition(new Long(request.getParameter("indicador.position")));
			return new ResponseEntity<Long>((Long)indicadorService.save(indicador), HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<Long>((Long)null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/eliminar")
	@ResponseBody
	public ResponseEntity<Indicador> eliminarIndicador(HttpServletRequest request, ModelMap model){
		Indicador indicador = indicadorService.get(new Long(request.getParameter("indicador.codigo")));
		indicadorService.delete(indicador);
		return new ResponseEntity<Indicador>(indicador, HttpStatus.ACCEPTED);
	}
}
