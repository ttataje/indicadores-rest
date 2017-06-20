package pe.gob.regionica.indicadores.rest.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.regionica.indicadores.rest.service.RestService;

@RestController
@RequestMapping(value = "/rest")
public class RestWS {

	private final Logger log = LoggerFactory.getLogger(RestWS.class);
	
	@Autowired
	private static RestService restService;
	
	@ResponseBody
	@RequestMapping(value = "/getChart", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getChart(Integer id) {
		log.debug("id : " + id);
		return restService.getChart(id);
	}
}
