package pe.gob.regionica.indicadores.rest.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="padre")
	private Indicador padre;
	
	@Column(name="tipo", length=20)
	private String tipo; // Determina el tipo de nodo (folder, chart)
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="padre", cascade = CascadeType.ALL)
	private Set<Indicador> children = new HashSet<Indicador>();

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

	public Set<Indicador> getChildren() {
		return children;
	}

	public void setChildren(Set<Indicador> children) {
		this.children = children;
	}
	
	
}
