package usuario;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ttps.clasesDAOImplJPA.UsuarioDAOHibernateJPA;
import ttps.clasesDeObjetosDelSistema.Usuario;

public class UsuarioDAOHibernateJPATest {
	
	private UsuarioDAOHibernateJPA usuario;
	
	public void setUp() {
		usuario = new UsuarioDAOHibernateJPA();
	}
	
	@Test
	public void testCreateUsuario() {
		usuario.guardar(new Usuario());
		Assertions.assertEquals(1,1);
	}
	
}
