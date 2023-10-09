import java.util.List;

public class Usuario {

	private String nombreUsuario;
	private String email;
	private String nombre;
	private String apellido;
	private String clave;
	private List<Gasto> gastos;
	private List<Grupo> grupos;
	private List<Pago> pagos;
	private List<Usuario> amigos;
	
	public Usuario() {
		
	}
	
	
	



	public Usuario(String nombreUsuario, String email, String nombre, String apellido, String clave, List<Gasto> gastos,
			List<Grupo> grupos, List<Pago> pagos, List<Usuario> amigos) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.clave = clave;
		this.gastos = gastos;
		this.grupos = grupos;
		this.pagos = pagos;
		this.amigos = amigos;
	}






	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}






	public List<Usuario> getAmigos() {
		return amigos;
	}






	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}
	
	
	
}
