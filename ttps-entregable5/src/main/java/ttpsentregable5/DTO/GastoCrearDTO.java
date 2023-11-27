package ttpsentregable5.DTO;

import java.util.Date;
import java.util.Map;

public class GastoCrearDTO {

	private double monto;
	private String imagen;
	private Date fecha;
	private Long idGrupo;
	private String categoria;
	private Long cargaGasto;
	private Long realizaGasto;
	private Long tipoDivisionGasto;
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
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
	public Long getTipoDivisionGasto() {
		return tipoDivisionGasto;
	}
	public void setTipoDivisionGasto(Long tipoDivisionGasto) {
		this.tipoDivisionGasto = tipoDivisionGasto;
	}
	
	
	
}
