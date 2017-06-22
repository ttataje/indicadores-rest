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

import pe.gob.regionica.indicadores.rest.bean.Color;
import pe.gob.regionica.indicadores.rest.service.ColorService;

@RestController
@RequestMapping(value = "/color")
public class ColorWS {

	private final Logger log = LoggerFactory.getLogger(ColorWS.class);
	
	@Autowired
	private static ColorService colorService;
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Color> list() {
		try{
			List<Color> result = colorService.list();
			return result;
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return ListUtils.EMPTY_LIST;
	}
}
