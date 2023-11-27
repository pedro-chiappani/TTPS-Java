package ttpsentregable5.DTO;

public class GrupoCrearDTO {
	
	private String nombre;
	private Long idUsuario;
	private String categoria;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setidUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
