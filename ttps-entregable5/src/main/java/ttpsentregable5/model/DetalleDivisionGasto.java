package ttpsentregable5.model;


import java.util.Optional;

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
@Table(name = "detalles_divisions_gastos")
public class DetalleDivisionGasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="detalle_division_gasto_id")
	private Long id;


	@ManyToOne
	@JoinColumn(name="gasto_id", nullable=false)
	private Gasto gasto;


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Column
	private double valor;
	
	public DetalleDivisionGasto() {
		
	}

	
	public DetalleDivisionGasto(Gasto unGasto, Usuario unUsu, double unValor) {
		this.setGasto(unGasto);
		this.setUsuario(unUsu);
		this.setValor(unValor);
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gasto getGasto() {
		return gasto;
	}

	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	//1-Fijo, 2-Porcentaje, 3-Igual

	/*
	 Dependiendo del tipo de division, 
	 al crearse una division gasto cuando se cargue el detalle,
	 que el mismo indica lo que le corresponde a cada usuario para cierto gasto,
	 el campo valor puede ser:
	 
	 	1(monto fijo) - un valor que representa un monto, cuyo monto es distinto entre los usaurios q comparten el gasto 
	 	2(porcentaje) - un valor que representa un porcentaje, que sirve para evaluar el monto a pagar de un gasto
	 	3(monto igual)- un valor que representa un monto, cuyo monto es igual entre los usuaroios q comparten el gasto
	*/
	
	
	
}