package ttps.clasificados;

public class Usuario {
	


	private String nombre;
	private String password;
	private String perfil;
	
	
	public Usuario(String nombre, String password, String perfil) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.perfil = perfil;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + ", perfil=" + perfil + "]";
	}
	
	
}
