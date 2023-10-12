package ttps.clasesDAO;
import ttps.clasesDeObjetosDelSistema.Usuario;
import java.util.List;

public interface UsuarioDAO {

	Usuario recuperar(Long id);
	Usuario recuperar(String nom);
	List<Usuario> recuperarTodos();
	void guardar(Usuario u);
	void actualizar(Usuario u);
	void borrar(Usuario u);
}
