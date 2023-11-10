package ttps.spring.DAOImpl;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.AuditoriaDAO;
import ttps.spring.model.Auditoria;

@Repository
public class AuditoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Auditoria> implements AuditoriaDAO{
	
	public AuditoriaDAOHibernateJPA() {
		super(Auditoria.class);
	}

}
