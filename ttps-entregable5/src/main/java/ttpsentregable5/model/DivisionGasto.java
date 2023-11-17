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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "divisiones_gastos")
public class DivisionGasto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="division_gasto_id")
	private Long id;
	
	@Column
	private int tipo; //1-Fijo, 2-Porcentaje, 3-Igual
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "gasto_id",nullable = false)
	private Gasto gasto;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "divisionGasto")
	private List<DetalleDivisionGasto> detalleDivisionGasto;



	public DivisionGasto() {

	}

	public DivisionGasto(int unTipo, Gasto unGasto) {		
		this.setTipo(unTipo);
		this.setGasto(unGasto);


	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Gasto getGasto() {
		return gasto;
	}
	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}

}
