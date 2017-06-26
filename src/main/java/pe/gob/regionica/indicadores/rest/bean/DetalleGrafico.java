package pe.gob.regionica.indicadores.rest.bean;

import java.math.BigDecimal;
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
	
	@ManyToOne
	private DetalleGrafico padre;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@OneToMany(mappedBy="padre")
	private Collection<DetalleGrafico> children;

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

	public Collection<DetalleGrafico> getChildren() {
		return children;
	}

	public void setChildren(Collection<DetalleGrafico> children) {
		this.children = children;
	}

}
