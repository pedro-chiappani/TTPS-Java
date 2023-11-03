package ttps.spring.DAOImpl;

import ttps.spring.DAO.DivisionGastoDAO;
import ttps.spring.model.DivisionGasto;

public class DivisionGastoDAOHibernateJPA extends GenericDAOHibernateJPA<DivisionGasto> implements DivisionGastoDAO {

	public DivisionGastoDAOHibernateJPA() {
		super(DivisionGasto.class);
	}
}
