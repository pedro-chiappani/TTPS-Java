package ttps.clasesDAO;
import ttps.clasesDeObjetosDelSistema.Usuario;
import java.util.List;

public interface UsuarioDAO extends GenericDAO<Usuario>{

	Usuario recuperar(String nom);
}
