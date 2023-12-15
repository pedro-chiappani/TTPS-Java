package ttpsentregable5.DTO;

public class UpdtGastoDTO {

	private String imagen;
	private String categoria;
	private Long cargaGasto;
	private Long realizaGasto;
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Long getCargaGasto() {
		return cargaGasto;
	}
	public void setCargaGasto(Long cargaGasto) {
		this.cargaGasto = cargaGasto;
	}
	public Long getRealizaGasto() {
		return realizaGasto;
	}
	public void setRealizaGasto(Long realizaGasto) {
		this.realizaGasto = realizaGasto;
	}
}
