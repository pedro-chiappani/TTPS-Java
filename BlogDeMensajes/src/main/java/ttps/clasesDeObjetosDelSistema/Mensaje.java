package ttps.clasesDeObjetosDelSistema;

public class Mensaje {
	
	private Long id;
	private String mensaje;
	private Long usuario;
	
	public Mensaje(String mensaje, Long usuarioId) {
		super();
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

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuarioId) {
		this.usuario = usuarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
