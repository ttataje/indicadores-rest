package pe.gob.regionica.indicadores.rest.ws;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.regionica.indicadores.rest.bean.Usuario;
import pe.gob.regionica.indicadores.rest.service.UsuarioService;

@RestController
public class UsuarioWS {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioWS.class);
	
	private static UsuarioService usuarioService;
	
	public UsuarioWS(){
		if(usuarioService == null) usuarioService = new UsuarioService();
	}
// x-auth-token
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario login(String username, String clave) {
		log.debug("login");
		Usuario usuario = null;
		return usuario;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
