package ttps.clasesDeObjetosDelSistema;

public class Usuario {
	
	private Long id;
	private String nombre;
	
	public Usuario (Long id, String nom) {
		this.setId(id);
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
