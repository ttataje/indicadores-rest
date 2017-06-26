package pe.gob.regionica.indicadores.rest.ws;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.gob.regionica.indicadores.rest.bean.Usuario;
import pe.gob.regionica.indicadores.rest.service.UsuarioService;
import pe.gob.regionica.indicadores.rest.utils.RestMD5;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioWS {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioWS.class);
	
	private static UsuarioService usuarioService;
	
	public UsuarioWS(){
		super();
		usuarioService = new UsuarioService();
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<Usuario> login(@RequestParam("username") String username, @RequestParam("clave") String clave, HttpServletRequest request, HttpServletResponse response) {
		log.debug("login");
		try{
			Usuario usuario = usuarioService.findUsuario(username);
			if(usuario != null){
				if(usuario.getPassword().equals(RestMD5.getMD5(clave))){
					return new ResponseEntity<Usuario>(usuario,HttpStatus.ACCEPTED);
				}
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return new ResponseEntity<Usuario>((Usuario)null, HttpStatus.BAD_REQUEST);
	}
}
