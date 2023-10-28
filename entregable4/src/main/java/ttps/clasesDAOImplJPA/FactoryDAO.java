package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.*;

public class FactoryDAO {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
	}

}
