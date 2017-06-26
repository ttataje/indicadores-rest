package pe.gob.regionica.indicadores.rest.ws;

import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.gob.regionica.indicadores.rest.bean.Color;
import pe.gob.regionica.indicadores.rest.service.ColorService;

@Controller
@RequestMapping(value = "/color")
public class ColorWS {

	private final Logger log = LoggerFactory.getLogger(ColorWS.class);
	
	private static ColorService colorService;
	
	public ColorWS(){
		super();
		colorService = new ColorService();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list")
	@ResponseBody
	public ResponseEntity<List<Color>> list() {
		try{
			List<Color> result = colorService.list();
			return new ResponseEntity<List<Color>>(result, HttpStatus.ACCEPTED);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return new ResponseEntity<List<Color>>(ListUtils.EMPTY_LIST, HttpStatus.ACCEPTED);
	}
}
