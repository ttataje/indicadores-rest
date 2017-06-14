package pe.gob.regionica.indicadores.rest.service;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import pe.gob.regionica.indicadores.rest.utils.RestConstants;

@Service
public class RestService {
	
	private final Logger log = LoggerFactory.getLogger(RestService.class);

	public byte[] getChart(Integer id) {
		String url = RestConstants.domain + RestConstants.motorURL;
		RestTemplate restTemplate = new RestTemplate();
		try{
		String input = "";
		if(id == null){
			File file = null;
			try {
				file = new File(this.getClass().getClassLoader().getResource("dummy.json").getFile());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			input = FileUtils.readFileToString(file, Charset.defaultCharset());
		}
		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.IMAGE_PNG));
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>(); 
		body.add("json", input);
		
		HttpEntity<?> entity = new HttpEntity<Object>(body,headers);
		
		ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.POST, entity, byte[].class, input);
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		if(response.getStatusCode().equals(HttpStatus.OK)){
			IOUtils.write(response.getBody(), output);
		}

		return output.toByteArray();
		
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return null;
	}
}
