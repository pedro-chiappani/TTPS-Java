package ttps.spring.DAOImpl;

import ttps.spring.DAO.*;

public class FactoryDAO {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
	}

}
