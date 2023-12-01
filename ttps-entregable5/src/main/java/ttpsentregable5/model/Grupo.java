package ttpsentregable5.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="grupo_id")
	private Long id;
	
	private String nombre;
	
	private double miSaldo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToMany(mappedBy = "grupos")
	private List<Usuario> usuarios;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "grupo")
	private List<Gasto> gastos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "grupo")
	private List<Pago> pagos;
	
	public Grupo() {
		
	}
	
	public Grupo(String nombre, Categoria cat, List<Usuario> usuarios) {
		this.nombre = nombre;
		this.categoria = cat;
		this.usuarios = usuarios;
		this.miSaldo = 0;
		this.gastos = null;
		this.pagos = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getMiSaldo() {
		return miSaldo;
	}

	public void setMiSaldo(double miSaldo) {
		this.miSaldo = miSaldo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
}
