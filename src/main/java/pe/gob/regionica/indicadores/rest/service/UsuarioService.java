package pe.gob.regionica.indicadores.rest.service;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pe.gob.regionica.indicadores.rest.bean.Usuario;

@Service
public class UsuarioService {

	private final Logger log = LoggerFactory.getLogger(UsuarioService.class);
	
	private static List<Usuario> usuarioList;

	public UsuarioService(){
		if(usuarioList == null){
			usuarioList = new ArrayList<Usuario>();
			try {
				File file = new File(this.getClass().getClassLoader().getResource("Usuario.json").getFile());
				JSONArray array = new JSONArray(FileUtils.readFileToString(file, Charset.defaultCharset()));
				for(int i = 0; i < array.length(); i++){
					JSONObject item = array.getJSONObject(i);
					Long codigo = item.getLong("codigo");
					String nombre = item.getString("nombre");
					String apellidoPaterno = item.getString("apellidoPaterno");
					String apellidoMaterno = item.getString("apellidoMaterno");
					String username = item.getString("username");
					String password = item.getString("password");
					String rol = item.getString("rol");
					usuarioList.add(new Usuario(codigo, nombre, apellidoPaterno, apellidoMaterno, username, password, rol));
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		} 
	}

	public Usuario findUsuario(String username){
		for(Usuario usuario : usuarioList){
			if(username.equalsIgnoreCase(usuario.getUsername()))
				return usuario;
		}
		return null;
	}
}
