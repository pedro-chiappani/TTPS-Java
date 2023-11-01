package usuario;

import java.util.List;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import ttps.clasesDAOImplJPA.UsuarioDAOHibernateJPA;
import ttps.clasesDeObjetosDelSistema.Usuario;




public class UsuarioDAOHibernateJPATest {
	
	private UsuarioDAOHibernateJPA usu = new UsuarioDAOHibernateJPA();
	
	
	@BeforeEach
	public void setUp(){
		Usuario usuario1 = new Usuario("usuario1", "usuario1@gmail.com", "usuario1Nombre", "usuario1Apellido", "123456", null, null, null, null);
		
		usu.guardar(usuario1);
	}
	
	@Test
	public void testCreateUsuario() {
		Usuario usuDB = usu.recuperar((long) 1);//usu.recuperarPorNombreUsuario("usuario1");
		
		Assertions.assertEquals("usuario1", usuDB.getNombreUsuario());
		Assertions.assertEquals("usuario1@gmail.com", usuDB.getEmail());
		Assertions.assertEquals("usuario1Nombre", usuDB.getNombre());
		Assertions.assertEquals("usuario1Apellido", usuDB.getApellido());
	}
	
	@Test
	public void testUpdateUsuario() {
				
		Usuario usuDB = usu.recuperarPorNombreUsuario("usuario1");
		Assertions.assertEquals("usuario1", usuDB.getNombreUsuario());
		
		usuDB.setEmail("usuario1MODIF@gmail.com");
		usuDB.setNombre("usuario1NombreMODIF");
		usuDB.setApellido("usuario1ApellidoMODIF");
		
		usu.actualizar(usuDB);
		
		Usuario usuModif = usu.recuperarPorNombreUsuario("usuario1");
			
		Assertions.assertEquals("usuario1", usuModif.getNombreUsuario());
		Assertions.assertEquals("usuario1MODIF@gmail.com", usuModif.getEmail());
		Assertions.assertEquals("usuario1NombreMODIF", usuModif.getNombre());
		Assertions.assertEquals("usuario1ApellidoMODIF", usuModif.getApellido());
	}
	
	
	
	
	@Test
	public void testAmigosUsuario() {
		Usuario usuario2 = new Usuario("usuario2", "usuario2@gmail.com", "usuario2Nombre", "usuario2Apellido", "123456", null, null, null, null);

		usu.guardar(usuario2);
		
		Usuario usu1DB = usu.recuperarPorNombreUsuario("usuario1");
		Usuario usu2DB = usu.recuperarPorNombreUsuario("usuario2");
		
		Assertions.assertEquals(0, usu1DB.getAmigos().size());
		
		usu1DB.agregarAmigos(usu2DB);
		usu.actualizar(usu1DB);
		
		Assertions.assertEquals(1, usu1DB.getAmigos().size());
	}
	
	
	@Test
	public void testDeleteUsuario() {
		
		Usuario usuDB = usu.recuperarPorNombreUsuario("usuario1");
		Assertions.assertEquals("usuario1", usuDB.getNombreUsuario());
		
		usu.borrar(usuDB);
		
		usuDB = usu.recuperarPorNombreUsuario("usuario1");
		
		
		Assertions.assertNull(usuDB);
	}
	
}