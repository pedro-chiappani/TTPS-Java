package ttps.clasesDAO;

import java.util.List;

import ttps.clasesDeObjetosDelSistema.Usuario;

public interface UsuarioDAO {

	Usuario recuperar(Long id);
	List<Usuario> recuperarTodos();
	void guardar(Usuario u);
	void actualizar(Usuario u);
	void borrar(Usuario u);
	
}
