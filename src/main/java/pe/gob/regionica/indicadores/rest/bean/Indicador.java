package pe.gob.regionica.indicadores.rest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="INDICADOR")
public class Indicador extends GenericBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="position")
	private Long position;
	
	@Column(name="padre")
	private Long padre;
	
	@Column(name="tipo", length=20)
	private String tipo; // Determina el tipo de nodo (folder, chart)

	@Formula("(select (count(i.codigo) > 0) from INDICADOR i where i.padre = codigo)")
	private Boolean children;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getPadre() {
		return padre;
	}

	public void setPadre(Long padre) {
		this.padre = padre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getChildren() {
		return children;
	}

	public void setChildren(Boolean children) {
		this.children = children;
	}
	
	
}
