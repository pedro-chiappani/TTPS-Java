package ttps.clasesDeObjetosDelSistema;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auditorias")
public class Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name="auditoria_id")
	private long id;
	
	@Column
	private Date fecha;
	
	@Column
	private String descripcion;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id",nullable = false)
	private Usuario usuario;
	
	public Auditoria() {
		
	}
	
	public Auditoria (Date unaFecha, String unaDescripcion, Usuario unUsuario) {
		this.setFecha(unaFecha);
		this.setDescripcion(unaDescripcion);
		this.setUsuario(unUsuario);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}