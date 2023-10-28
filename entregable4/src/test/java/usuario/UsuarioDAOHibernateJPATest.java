package usuario;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ttps.clasesDAOImplJPA.UsuarioDAOHibernateJPA;
import ttps.clasesDeObjetosDelSistema.Usuario;

public class UsuarioDAOHibernateJPATest {
	
	private UsuarioDAOHibernateJPA usu;
	
	@Test
	public void testCreateUsuario() {
		usu = new UsuarioDAOHibernateJPA();
		usu.guardar(new Usuario());
		Assertions.assertEquals(1,1);
	}
	
}
