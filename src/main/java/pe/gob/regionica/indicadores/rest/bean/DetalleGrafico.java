package pe.gob.regionica.indicadores.rest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DETALLE_GRAFICO")
public class DetalleGrafico extends GenericBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="grafico")
	private Long grafico;
	
	@Column(name="data")
	private String data;

	@Column(name="attributes")
	private String attributes;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getGrafico() {
		return grafico;
	}

	public void setGrafico(Long grafico) {
		this.grafico = grafico;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
}
