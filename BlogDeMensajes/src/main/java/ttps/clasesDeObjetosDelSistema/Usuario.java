package ttps.clasesDeObjetosDelSistema;

public class Usuario {

	private Long id;
	private String nombre;
	private int dni;
	
	public Usuario (Long id, String nom, int dni) {
		this.setId(id);
		this.setDni(dni);
		this.setNombre(nom);
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
