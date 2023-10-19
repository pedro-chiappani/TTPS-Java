package ttps.clasesDeObjetosDelSistema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name="usuario_id")
	private Long id;
	
	@Column
	private String nombre;
	
	public Usuario (Long id, String nom) {
		this.setId(id);
		this.setNombre(nom);
	}
	
	public Usuario() {}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
