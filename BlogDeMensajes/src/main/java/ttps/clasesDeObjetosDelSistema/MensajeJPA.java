package ttps.clasesDeObjetosDelSistema;

import javax.persistence.*;


@Entity
@Table(name="MensajeJPA")
public class MensajeJPA implements java.io.Serializable {
	
	@Id @GeneratedValue
	@Column(name="mensaje_id")
	private Long id;
	
	@Column
	private String mensaje;
	
	@Column
	private String usuario;
	
	 
	public MensajeJPA() {}
	
	public MensajeJPA(Long id, String mensaje, String usuario) {
		super();
		this.setId(id);
		this.setMensaje(mensaje);
		this.setUsuario(usuario);
	}
	 
	public Long getId(){
		return this.id;
	}
	 
	private void setId(Long id){
		this.id = id;
	}
	 
	public String getUsuario(){
		return this.usuario;
	}
	 
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	 
	public String getMensaje() {
		return this.mensaje;
	}
	 
	public void setMensaje(String mensaje) {
		this.mensaje=mensaje;
	}
 
 
}

