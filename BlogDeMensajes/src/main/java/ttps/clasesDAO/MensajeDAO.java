package ttps.clasesDAO;
import ttps.clasesDeObjetosDelSistema.Mensaje;

import java.util.List;

public interface MensajeDAO {

	Mensaje recuperar(Long id);
	List<Mensaje> recuperarTodos();
	void guardar(Mensaje m);
	void actualizar(Mensaje m);
	void borrar(Mensaje m);
}
