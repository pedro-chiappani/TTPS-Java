package ttps.spring.DAOImpl;

import ttps.spring.DAO.UsuarioDAO;

public class FactoryDAO {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
	}

}
