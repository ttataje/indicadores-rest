package pe.gob.regionica.indicadores.rest.bean;

import java.math.BigDecimal;
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
@Table(name="DETALLE_GRAFICO")
public class DetalleGrafico extends GenericBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="grafico")
	private Long grafico;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="padre")
	private DetalleGrafico padre;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="padre", cascade = CascadeType.ALL)
	private Set<DetalleGrafico> children = new HashSet<DetalleGrafico>();

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

	public Long getGrafico() {
		return grafico;
	}

	public void setGrafico(Long grafico) {
		this.grafico = grafico;
	}

	public DetalleGrafico getPadre() {
		return padre;
	}

	public void setPadre(DetalleGrafico padre) {
		this.padre = padre;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Set<DetalleGrafico> getChildren() {
		return children;
	}

	public void setChildren(Set<DetalleGrafico> children) {
		this.children = children;
	}

}
