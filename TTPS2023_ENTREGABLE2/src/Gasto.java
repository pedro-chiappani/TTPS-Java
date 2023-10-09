import java.io.File;
import java.util.Date;

public class Gasto {

	private double monto;
	private File imagen;
	private Date fecha;
	private Grupo grupo;
	private Categoria categoria;
	private Usuario cargaGasto;
	private Usuario realizaGasto;
	private EstrategiaDivision estrategiaDivision;
	
	
	
	
	public Gasto(double monto, File imagen, Date fecha, Grupo grupo, Categoria categoria, Usuario cargaGasto,
			Usuario realizaGasto, EstrategiaDivision estrategiaDivision) {
		super();
		this.monto = monto;
		this.imagen = imagen;
		this.fecha = fecha;
		this.grupo = grupo;
		this.categoria = categoria;
		this.cargaGasto = cargaGasto;
		this.realizaGasto = realizaGasto;
		this.estrategiaDivision = estrategiaDivision;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public File getImagen() {
		return imagen;
	}
	public void setImagen(File imagen) {
		this.imagen = imagen;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Usuario getCargaGasto() {
		return cargaGasto;
	}
	public void setCargaGasto(Usuario cargaGasto) {
		this.cargaGasto = cargaGasto;
	}
	public Usuario getRealizaGasto() {
		return realizaGasto;
	}
	public void setRealizaGasto(Usuario realizaGasto) {
		this.realizaGasto = realizaGasto;
	}
	public EstrategiaDivision getEstrategiaDivision() {
		return estrategiaDivision;
	}
	public void setEstrategiaDivision(EstrategiaDivision estrategiaDivision) {
		this.estrategiaDivision = estrategiaDivision;
	}
	
	
	
	
}
