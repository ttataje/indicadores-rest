package pe.gob.regionica.indicadores.rest.bean;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="INDICADORES")
public class Indicador extends GenericBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	private Indicador padre;
	
	@Column(name="tipo", length=20)
	private String tipo; // Determina el tipo de nodo (folder, chart)
	
	@OneToMany(mappedBy="padre")
	private Collection<Indicador> children;

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

	public Indicador getPadre() {
		return padre;
	}

	public void setPadre(Indicador padre) {
		this.padre = padre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Collection<Indicador> getChildren() {
		return children;
	}

	public void setChildren(Collection<Indicador> children) {
		this.children = children;
	}
	
	
}
