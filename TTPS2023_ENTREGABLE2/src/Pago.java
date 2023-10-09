import java.util.Date;

public class Pago {

	private double monto;
	private Date fecha;
	private Usuario usuario;
	private Grupo grupo;
	
	
	public Pago() {
		
	}
	
	
	public Pago(double monto, Date fecha, Usuario usuario, Grupo grupo) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.usuario = usuario;
		this.grupo = grupo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	
	
}
