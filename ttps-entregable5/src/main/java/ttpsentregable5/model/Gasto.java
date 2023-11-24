package ttpsentregable5.model;

import java.io.File;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "gastos")
public class Gasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="gasto_id")
	private Long id;
	
	private double monto;
	
	private File imagen;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="group_id", nullable=false)
	private Grupo grupo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_carga_id")
	private Usuario cargaGasto;
	
	@ManyToOne
	@JoinColumn(name = "usuario_realiza_id")
	private Usuario realizaGasto;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "divisiones_gasto_id")
	private DivisionGasto divisionGasto;
	
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
	public File getImagen() {
		return imagen;
	}
	public void setImagen(File imagen) {
		this.imagen = imagen;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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

	public DivisionGasto getDivisionGasto() {
		return divisionGasto;
	}

	public void setDivisionGasto(DivisionGasto divisionGasto) {
		this.divisionGasto = divisionGasto;
	}


}