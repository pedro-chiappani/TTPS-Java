package ttps.spring.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;

public class TestSpringSimple {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		// registra una o más componentes que serán procesadas
		ctx.register(ttps.spring.config.PersistenceConfig.class);
		
		// Busca clases anotadas en el paquete base pasado por parámetro
		ctx.scan("ttps");
		ctx.refresh();
		
		UsuarioDAO usrDAO = ctx.getBean("usuarioDAOHibernateJPA", UsuarioDAO.class);
		
		usrDAO.guardar( new Usuario("joaquingrosso","joagrosso@hotmail.com","joaquin","grosso","123456",null,null,null,null) );
		usrDAO.guardar( new Usuario("pepechiappa","pepechiappa@hotmail.com","pedro","chiappiani","123456",null,null,null,null) );
		usrDAO.guardar( new Usuario("tobiaj","tobiaj@hotmail.com","tobias","ajenjo","123456",null,null,null,null) );
		
		
		List<Usuario> usuarios = usrDAO.recuperarTodos();
		
		for(Usuario u: usuarios) {
			System.out.println(u.getNombreUsuario() 
					+ " - " + u.getEmail() 
					+ " - " + u.getNombre() + ", " + u.getApellido() );
		}
	}

}
