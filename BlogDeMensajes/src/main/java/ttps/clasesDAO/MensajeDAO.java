package ttps.clasesDAO;

import java.util.List;

import ttps.clasesDeObjetosDelSistema.Mensaje;

public interface MensajeDAO {

	Mensaje recuperar(Long id);
	List<Mensaje> recuperarTodos();
	void guardar(Mensaje m);
	void actualizar(Mensaje m);
	void borrar(Mensaje m);
}