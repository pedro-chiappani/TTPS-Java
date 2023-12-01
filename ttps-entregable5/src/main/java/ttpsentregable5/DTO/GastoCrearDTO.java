package ttpsentregable5.DTO;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class GastoCrearDTO {

	private Double monto;
	private String imagen;
	private String fecha;
	private Long idGrupo;
	private String categoria;
	private Long cargaGasto;
	private Long realizaGasto;
	private Long tipoDivisionGasto;
	private List<ElementoDetalleGastoDTO> detalleDivisionGasto;
	
	//Ejemplo msj: suponiendo que el grupo1 tiene 3 miembros: idusu1,idusu2,idusu5 y idusu8
			//{
//				"monto": 1000,
//				"imagen": "asdasd",
//				"fecha": "sysdate",
//				"grupo": idgrupo1,
//				"categoria": "nombrecategoria",
//				"cargaGasto" : idusu1,
//				"realizaGasto" : idusu2,
//				"tipoDivisionGasto": 1	
//				"divisiongasto": {									
//						{
//							"usu1": idusu1,
//							"valor": 100
//						},
//						{
//							"usu2": idusu2,
//							"valor": 500
//						},
//						{
//							"usu3": idusu5,
//							"valor": 500
//						},
//						{
//							"usu4": idusu8,
//							"valor": 900
//						}
//					}
//				}
			//}
	
	
	
	public Double getMonto() {
		return monto;
	}	
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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
	public List<ElementoDetalleGastoDTO> getDetalleDivisionGasto() {
		return detalleDivisionGasto;
	}
	public void setDetalleDivisionGasto(List<ElementoDetalleGastoDTO> detalleDivisionGasto) {
		this.detalleDivisionGasto = detalleDivisionGasto;
	}
	
	
	
	
	
}