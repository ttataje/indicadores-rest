package pe.gob.regionica.indicadores.rest.ws;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import pe.gob.regionica.indicadores.rest.bean.DetalleGrafico;
import pe.gob.regionica.indicadores.rest.service.DetalleGraficoService;

@Controller
@RequestMapping(value = "/detalleGrafico")
public class DetalleGraficoWS {

	private final Logger log = LoggerFactory.getLogger(DetalleGraficoWS.class);

	@Autowired
	private DetalleGraficoService detalleGraficoService;
	
	public DetalleGraficoWS(){
		super();
	}
	
	@RequestMapping(value = "/get")
	@ResponseBody
	public ResponseEntity<DetalleGrafico> get(HttpServletRequest request, ModelMap model){
		DetalleGrafico detalleGrafico = null;
		try{
			String codigo = request.getParameter("codigo");
			detalleGrafico = detalleGraficoService.get(new Long(codigo));
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<DetalleGrafico>(detalleGrafico, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<DetalleGrafico>(detalleGrafico, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/getByParent")
	@ResponseBody
	public ResponseEntity<List<DetalleGrafico>> getByParent(HttpServletRequest request, ModelMap model){
		List<DetalleGrafico> detalleGrafico = null;
		try{
			String codigo = request.getParameter("codigo");
			detalleGrafico = detalleGraficoService.getByParent(StringUtils.isEmpty(codigo) ? null : new Long(codigo));
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<List<DetalleGrafico>>(detalleGrafico, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<DetalleGrafico>>(detalleGrafico, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/getByChart")
	@ResponseBody
	public ResponseEntity<List<DetalleGrafico>> getByChart(HttpServletRequest request, ModelMap model){
		List<DetalleGrafico> detalleGrafico = null;
		try{
			String codigo = request.getParameter("codigo");
			detalleGrafico = detalleGraficoService.getByChart(StringUtils.isEmpty(codigo) ? null : new Long(codigo));
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<List<DetalleGrafico>>(detalleGrafico, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<DetalleGrafico>>(detalleGrafico, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/modificar")
	@ResponseBody
	public ResponseEntity<DetalleGrafico> modificarDetalleGrafico(HttpServletRequest request, ModelMap model){
		try{
			DetalleGrafico detalleGrafico = detalleGraficoService.get(new Long(request.getParameter("detalle.codigo")));
			if(!StringUtils.isEmpty(request.getParameter("detalle.grafico.codigo"))){
				detalleGrafico.setGrafico(new Long(request.getParameter("detalle.grafico.codigo")));
			}
			if(!StringUtils.isEmpty(request.getParameter("detalle.descripcion"))){
				detalleGrafico.setDescripcion(request.getParameter("detalle.descripcion"));
			}
			if(!StringUtils.isEmpty(request.getParameter("detalle.valor"))){
				detalleGrafico.setValor(new BigDecimal(request.getParameter("detalle.valor")));
			}
			if(!StringUtils.isEmpty(request.getParameter("detalle.borderColor"))){
				detalleGrafico.setBorderColor(request.getParameter("detalle.borderColor"));
			}
			if(!StringUtils.isEmpty(request.getParameter("detalle.tipo"))){
				detalleGrafico.setTipo(request.getParameter("detalle.tipo"));
			}
			detalleGraficoService.update(detalleGrafico);
			return new ResponseEntity<DetalleGrafico>(detalleGrafico, HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<DetalleGrafico>((DetalleGrafico)null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/guardar")
	@ResponseBody
	public ResponseEntity<Long> guardarDetalleGrafico(HttpServletRequest request, ModelMap model){
		try{
			DetalleGrafico detalleGrafico = new DetalleGrafico();
			if(StringUtils.isEmpty(request.getParameter("detalle.padre.codigo"))){
				detalleGrafico.setGrafico(new Long(request.getParameter("detalle.grafico.codigo")));
			}else{
				detalleGrafico.setPadre(new Long(request.getParameter("detalle.padre.codigo")));
			}
			if(StringUtils.isEmpty(request.getParameter("detalle.descripcion"))){
				detalleGrafico.setValor(new BigDecimal(request.getParameter("detalle.valor")));
			}else{
				detalleGrafico.setDescripcion(request.getParameter("detalle.descripcion"));
			}
			
			return new ResponseEntity<Long>((Long)detalleGraficoService.save(detalleGrafico), HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
			return new ResponseEntity<Long>((Long)null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/eliminar")
	@ResponseBody
	public ResponseEntity<DetalleGrafico> eliminarDetalleGrafico(HttpServletRequest request, ModelMap model){
		DetalleGrafico detalleGrafico = null;
		try{
			detalleGrafico = detalleGraficoService.get(new Long(request.getParameter("detalle.codigo")));
			detalleGraficoService.delete(detalleGrafico);
		}catch(Exception e){}
		return new ResponseEntity<DetalleGrafico>(detalleGrafico, HttpStatus.ACCEPTED);
	}
}
