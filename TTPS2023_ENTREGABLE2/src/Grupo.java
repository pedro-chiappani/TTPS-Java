import java.util.List;

public class Grupo {

	private String nombre;
	private double saldo;
	private Categoria categoria;
	private List<Usuario> miembros;
	private List<Pago> pagos;
	private List<Gasto> gastos;
	
	
	
	public Grupo(String nombre, double saldo, Categoria categoria, List<Usuario> miembros, List<Pago> pagos,
			List<Gasto> gastos) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
		this.categoria = categoria;
		this.miembros = miembros;
		this.pagos = pagos;
		this.gastos = gastos;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Usuario> getMiembros() {
		return miembros;
	}
	public void setMiembros(List<Usuario> miembros) {
		this.miembros = miembros;
	}
	public List<Pago> getPagos() {
		return pagos;
	}
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	public List<Gasto> getGastos() {
		return gastos;
	}
	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	
	
}
