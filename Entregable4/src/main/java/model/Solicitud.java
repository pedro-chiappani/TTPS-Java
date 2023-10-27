package model;

import java.util.Date;

public class Solicitud {

	private Date fehca;
	private String estado;
	private Usuario creador;
	private Grupo grupo;
	
	
	
	public Solicitud(Date fehca, String estado, Usuario creador, Grupo grupo) {
		super();
		this.fehca = fehca;
		this.estado = estado;
		this.creador = creador;
		this.grupo = grupo;
	}
	public Date getFehca() {
		return fehca;
	}
	public void setFehca(Date fehca) {
		this.fehca = fehca;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	
}
