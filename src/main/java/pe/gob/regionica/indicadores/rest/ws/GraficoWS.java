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

import pe.gob.regionica.indicadores.rest.bean.Grafico;
import pe.gob.regionica.indicadores.rest.service.GraficoService;

@Controller
@RequestMapping(value = "/grafico")
public class GraficoWS {

	private final Logger log = LoggerFactory.getLogger(GraficoWS.class);

	@Autowired
	private GraficoService graficoService;
	
	public GraficoWS(){
		super();
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
	public ResponseEntity<Grafico> cargarGrafico(HttpServletRequest request, ModelMap model){
		Grafico grafico = null;
		try{
			String codigo = request.getParameter("codigo");
			grafico = graficoService.get(StringUtils.isEmpty(codigo) ? null : new Long(codigo));
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<Grafico>(grafico, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Grafico>(grafico, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/modificar")
	@ResponseBody
	public ResponseEntity<Grafico> modificarGrafico(HttpServletRequest request, ModelMap model){
		try{
			Grafico grafico = new Grafico();
			grafico.setCodigo(new Long(request.getParameter("grafico.codigo")));
			grafico.setIndicador(new Long(request.getParameter("grafico.indicador")));
			grafico.setTipo(request.getParameter("grafico.tipo"));
			graficoService.update(grafico);
			return new ResponseEntity<Grafico>(grafico, HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<Grafico>((Grafico)null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/guardar")
	@ResponseBody
	public ResponseEntity<Long> guardarGrafico(HttpServletRequest request, ModelMap model){
		try{
			Grafico grafico = new Grafico();
			grafico.setIndicador(new Long(request.getParameter("grafico.indicador")));
			grafico.setTipo(request.getParameter("grafico.tipo"));
			return new ResponseEntity<Long>((Long)graficoService.save(grafico), HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<Long>((Long)null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/eliminar")
	@ResponseBody
	public ResponseEntity<Grafico> eliminarGrafico(HttpServletRequest request, ModelMap model){
		Grafico grafico = null;
		try{
			grafico = graficoService.get(new Long(request.getParameter("grafico.codigo")));
			graficoService.delete(grafico);
		}catch(Exception e){}
		return new ResponseEntity<Grafico>(grafico, HttpStatus.ACCEPTED);
	}
}
