package pe.gob.regionica.indicadores.rest.bean;

import org.springframework.stereotype.Component;

@Component
public class Response extends GenericBean{

	private static final long serialVersionUID = 1L;

	private String status;
	
	private String message;
	
	private Object object;
	
	public Response() {
		super();
	}
	
	public Response(String status, Object object) {
		super();
		this.status = status;
		this.object = object;
	}

	public Response(String status, Object object, String message) {
		super();
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
