package ttps.spring.DAOImpl;

import ttps.spring.DAO.GastoDAO;
import ttps.spring.model.Gasto;

public class GastoDAOHibernateJPA extends GenericDAOHibernateJPA<Gasto> implements GastoDAO {
	
	public GastoDAOHibernateJPA() {
		super(Gasto.class);
	}

}
