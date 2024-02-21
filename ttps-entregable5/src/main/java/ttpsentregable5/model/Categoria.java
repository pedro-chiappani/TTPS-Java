package ttpsentregable5.model;

import java.io.File;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="categoria_id")
	private Long id;
	
	private String nombre;
	
	private File imagen;
	
	private int tipo;

	public String getNombre() {
		return this.nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getImagen() {
		return imagen;
	}

	public void setImagen(File imagen) {
		this.imagen = imagen;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
