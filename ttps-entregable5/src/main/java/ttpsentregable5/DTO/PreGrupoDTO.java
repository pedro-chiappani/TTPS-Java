package ttpsentregable5.DTO;

public class PreGrupoDTO {

	private String nombreUsuario;
	private String categoria;
	private String nombre;
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String toString() {
		return this.getNombre() + "-" + this.getCategoria() + " creado por: " + this.getNombreUsuario();
	}
}
