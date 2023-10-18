package ttps.clasesDeObjetosDelSistema;

import javax.persistence.*;

@Entity
@Table(name="mensaje")
public class Mensaje {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="mensaje_id")
	private Long id;
	
	@Column
	private String mensaje;
	
	@ManyToOne
	private Usuario usuario;
	
	public Mensaje(Long id, String mensaje, Usuario usuario) {
		super();
		this.setId(id);
		this.setMensaje(mensaje);
		this.setUsuario(usuario);
	}

	public Mensaje() {}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String toString() {
		return this.getMensaje() + " - " + this.getUsuario().getNombre();
	}
	
}
