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
	
	public Usuario(Usuario usu) {
		this.nombre = usu.getNombre();
		this.clave = usu.getPassword();
		this.perfil = usu.getPerfil();
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
