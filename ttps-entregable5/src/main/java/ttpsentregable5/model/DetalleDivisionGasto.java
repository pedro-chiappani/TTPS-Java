package ttpsentregable5.model;


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
	@JoinColumn(name="division_gasto_id", nullable=false)
	private DivisionGasto divisionGasto;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Column
	private double valor;

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
