package pe.gob.regionica.indicadores.rest.utils;

public class RestConstants {

	public static final String domain = "http://localhost:8080";
	
	public static final String motorURL = "/motor/generate";
	
	public static final String json = "json";
	
	public static final String AlgoritmoCrypt = "MD5";
	
	static class roles{
		public static final String administrador = "Administrador";
		public static final String consultor = "Consultor";
		public static final String mantenimiento = "Mantenimiento";
	}
	
	static class tipoIndicador{
		public static final String folder = "folder";
		public static final String chart = "chart";
	}
}
