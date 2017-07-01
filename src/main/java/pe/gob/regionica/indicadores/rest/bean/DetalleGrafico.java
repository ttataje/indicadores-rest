package pe.gob.regionica.indicadores.rest.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

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
	
	@Column(name="padre")
	private Long padre;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@Column(name="tipo")
	private String tipo = "bar";
	
	@Column(name="label")
	private String label;
	
	@Column(name="borderColor")
	private String borderColor;
	
	@Column(name="borderWidth")
	private Long borderWidth = new Long (2);
	
	//fill: false,
	
	@Formula("(select (count(dg.codigo) > 0) from DETALLE_GRAFICO dg where dg.padre = codigo)")
	private Boolean children = Boolean.FALSE;

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

	public Long getPadre() {
		return padre;
	}

	public void setPadre(Long padre) {
		this.padre = padre;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Boolean getChildren() {
		return children;
	}

	public void setChildren(Boolean children) {
		this.children = children;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public Long getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Long borderWidth) {
		this.borderWidth = borderWidth;
	}

}
