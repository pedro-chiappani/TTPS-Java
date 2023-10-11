package ttps.clasesDeObjetosDelSistema;

import javax.persistence.*;

@Entity
@Table(name="Mensaje")
public class Mensaje {

	@Id @GeneratedValue
	@Column(name="mensaje_id")
	private Long id;
	
	@Column
	private String mensaje;
	
	@Column
	private String usuario;
	
	public Mensaje(Long id, String mensaje, String usuario) {
		super();
		this.setId(id);
		this.setMensaje(mensaje);
		this.setUsuario(usuario);
	}

	public Mensaje() {}
	
	public String toString() {
		return this.getMensaje() + " - Usuario: " + this.getUsuario();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
