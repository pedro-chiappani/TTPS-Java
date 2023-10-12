package ttps.clasesDAO;
import ttps.clasesDeObjetosDelSistema.Usuario;
import java.util.List;

public interface UsuarioDAO {

	Usuario recuperar(Long id);
	List<Usuario> recuperarTodos();
	Usuario recuperarPorNombre(String unNombre);
	void guardar(Usuario u);
	void actualizar(Usuario u);
	void borrar(Usuario u);
}
