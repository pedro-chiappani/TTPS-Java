package test.ttps.spring.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;


public class TestSimpleSpring {
	public static void main(String[] args) {
		try {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//registra una o más componentes que serán procesadas
		ctx.register(ttps.spring.config.PersistenceConfig.class);
//Busca clases anotadas en el paquete base pasado por parámetro
		
		ctx.scan("ttps.spring");
		ctx.refresh();
		
		UsuarioDAO usrDAO = ctx.getBean("usuarioDAOHibernateJPA", UsuarioDAO.class);
		Usuario us = new Usuario("Pepe00", "pepe@mail.com","Pedro", "Chiappani", "1234",null,null,null, null);
		usrDAO.guardar(us);
		Usuario usu = usrDAO.recuperar((long) 1);
		System.out.print(usu.getNombre());
//		List<Usuario> usus = usrDAO.recuperarTodos();
//		for (Usuario u:usus) {
//			// formato clasico
//			System.out.println(u.getNombre());
//			System.out.println(u.getApellido());
//			System.out.println(u.getEmail());
//			}
		ctx.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
