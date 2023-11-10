package ttps.spring.DAOImpl;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.GrupoDAO;
import ttps.spring.model.Grupo;

@Repository
public class GrupoDAOHibernateJPA extends GenericDAOHibernateJPA<Grupo> implements GrupoDAO {

	public GrupoDAOHibernateJPA() {
		super(Grupo.class);
	}
	
	

}
