package ttpsentregable5.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "pagos")
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="gasto_id")
	private Long id;
	
	private double monto;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="grupo_pago", nullable=false)
	private Grupo grupo;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}

