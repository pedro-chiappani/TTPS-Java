package ttpsentregable5.DTO;

public class ElementoDetalleGastoDTO {

	private Long idUsu;
	private double valor;
	
	
	public Long getIdUsu() {
		return idUsu;
	}
	public void setIdUsu(Long idUsu) {
		this.idUsu = idUsu;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "" + this.idUsu + this.valor;
	}
}