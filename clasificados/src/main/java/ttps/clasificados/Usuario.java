package ttps.clasificados;

public class Usuario {
	
	private String nombre;
	private String clave;
	private String perfil;
	
	public Usuario(String nombre, String clave, String perfil) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.perfil = perfil;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getPassword() {
		return clave;
	}
	
	public String getPerfil() {
		return perfil;
	}
	
}
