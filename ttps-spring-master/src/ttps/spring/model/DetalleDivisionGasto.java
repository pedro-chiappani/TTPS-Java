package ttps.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_divisiones_gastos")
public class DetalleDivisionGasto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="detalle_division_gasto_id")
	private Long id;


	@ManyToOne
	@JoinColumn(name="division_gasto_id", nullable=false)
	private Grupo divisionGasto;


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
