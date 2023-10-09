import java.util.Date;

public class Auditoria {

	private Date fecha;
	private String descripcion;
	private Usuario usuario;
	
	public Auditoria() {
		
	}
	
	public Auditoria (Date unaFecha, String unaDescripcion, Usuario unUsuario) {
		this.setFecha(unaFecha);
		this.setDescripcion(unaDescripcion);
		this.setUsuario(unUsuario);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
