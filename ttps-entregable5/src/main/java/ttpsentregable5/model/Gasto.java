package ttpsentregable5.model;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "gastos")
public class Gasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="gasto_id")
	private Long id;
	
	@Column
	private double monto;
	
	@Column
	private String imagen;
	
	@Column
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name="group_id", nullable=false)
	@JsonIgnore
	private Grupo grupo;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
	private Categoria categoria;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_carga_id")
	@JsonIgnore
	private Usuario cargaGasto;
	
	@ManyToOne
	@JoinColumn(name = "usuario_realiza_id")
	@JsonIgnore
	private Usuario realizaGasto;
	
	@Column
	@JsonIgnore
	private int tipoDivisionGasto; //1-Fijo, 2-Porcentaje, 3-Igual
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "gasto")
	private List<DetalleDivisionGasto> detalleDivisionGasto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Usuario getCargaGasto() {
		return cargaGasto;
	}
	public void setCargaGasto(Usuario cargaGasto) {
		this.cargaGasto = cargaGasto;
	}
	public Usuario getRealizaGasto() {
		return realizaGasto;
	}
	public void setRealizaGasto(Usuario realizaGasto) {
		this.realizaGasto = realizaGasto;
	}
	public int getTipoDivisionGasto() {
		return tipoDivisionGasto;
	}
	public void setTipoDivisionGasto(int tipo) {
		this.tipoDivisionGasto = tipo;
	}
	public List<DetalleDivisionGasto> getDetalleDivisionGasto() {
		return detalleDivisionGasto;
	}
	public void setDetalleDivisionGasto(List<DetalleDivisionGasto> detalleDivisionGasto) {
		this.detalleDivisionGasto = detalleDivisionGasto;
	}
	

	

}