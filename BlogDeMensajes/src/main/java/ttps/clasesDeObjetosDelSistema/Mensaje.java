package ttps.clasesDeObjetosDelSistema;

public class Mensaje {
	
	private Long id;
	private String mensaje;
	private Usuario usuario;
	
	public Mensaje(Long id, String mensaje, Usuario usuarioId) {
		super();
		this.setId(id);
		this.setMensaje(mensaje);
		this.setUsuario(usuarioId);
	}

	public Mensaje() {
		// TODO Auto-generated constructor stub
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuarioId) {
		this.usuario = usuarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
