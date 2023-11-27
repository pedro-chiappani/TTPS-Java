package ttpsentregable5.DTO;

public class PreGrupoDTO {

	private Long idUsuario;
	private String categoria;
	private String nombre;
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
		return this.getNombre() + "-" + this.getCategoria() + " creado por: " + this.getIdUsuario();
	}
}
