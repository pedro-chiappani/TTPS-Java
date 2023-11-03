package ttps.spring.DAOImpl;

import ttps.spring.DAO.AuditoriaDAO;
import ttps.spring.model.Auditoria;

public class AuditoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Auditoria> implements AuditoriaDAO{
	
	public AuditoriaDAOHibernateJPA() {
		super(Auditoria.class);
	}

}
