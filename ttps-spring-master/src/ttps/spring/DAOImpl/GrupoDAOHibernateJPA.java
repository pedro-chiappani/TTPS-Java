package ttps.spring.DAOImpl;

import ttps.spring.DAO.GrupoDAO;
import ttps.spring.model.Grupo;

public class GrupoDAOHibernateJPA extends GenericDAOHibernateJPA<Grupo> implements GrupoDAO {

	public GrupoDAOHibernateJPA() {
		super(Grupo.class);
	}
	
	

}
