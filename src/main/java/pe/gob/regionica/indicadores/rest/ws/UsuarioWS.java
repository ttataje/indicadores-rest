package pe.gob.regionica.indicadores.rest.ws;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.regionica.indicadores.rest.bean.Usuario;
import pe.gob.regionica.indicadores.rest.service.UsuarioService;
import pe.gob.regionica.indicadores.rest.utils.RestMD5;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioWS {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioWS.class);
	
	@Autowired
	private static UsuarioService usuarioService;
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario login(String username, String clave) {
		log.debug("login");
		try{
			Usuario usuario = usuarioService.findUsuario(username);
			if(usuario != null){
				if(usuario.getPassword().equals(RestMD5.getMD5(clave))){
					return usuario;
				}
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
