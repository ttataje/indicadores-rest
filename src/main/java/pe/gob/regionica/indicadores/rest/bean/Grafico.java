package pe.gob.regionica.indicadores.rest.bean;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GRAFICO")
public class Grafico extends GenericBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="indicador", nullable=false)
	private Indicador indicador;
	
	@Column(name="tipo", length=20, nullable=false)
	private String tipo;
	
	@OneToMany(mappedBy="grafico")
	private Collection<DetalleGrafico> data;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Collection<DetalleGrafico> getData() {
		return data;
	}

	public void setData(Collection<DetalleGrafico> data) {
		this.data = data;
	}

}
