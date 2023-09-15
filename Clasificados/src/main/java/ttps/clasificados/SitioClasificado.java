package ttps.clasificados;


public class SitioClasificado {

	private String nombre;
	private String email;
	private String telefono;
	
	public SitioClasificado(String unNombre, String unEmail, String unTelefono) {
		this.email = unEmail;
		this.nombre = unNombre;
		this.telefono = unTelefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
