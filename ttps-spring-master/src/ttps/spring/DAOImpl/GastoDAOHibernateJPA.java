package ttps.spring.DAOImpl;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.GastoDAO;
import ttps.spring.model.Gasto;

@Repository
public class GastoDAOHibernateJPA extends GenericDAOHibernateJPA<Gasto> implements GastoDAO {
	
	public GastoDAOHibernateJPA() {
		super(Gasto.class);
	}

}
