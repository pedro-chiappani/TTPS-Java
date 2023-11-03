package test.ttps.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ttps.spring.DAO.UsuarioDAO;

public class TestSimpleSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//registra una o más componentes que serán procesadas
		ctx.register(ttps.spring.config.PersistenceConfig.class);
//Busca clases anotadas en el paquete base pasado por parámetro
		ctx.scan("ttps");
		ctx.refresh();
		UsuarioDAO usrDAO = ctx.getBean("usuarioDAOHibernateJPA", UsuarioDAO.class);
		System.out.println(usrDAO.recuperarTodos());
	}
}
