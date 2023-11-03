package ttps.spring.DAOImpl;

import ttps.spring.DAO.DetalleDivisionGastoDAO;
import ttps.spring.model.DetalleDivisionGasto;

public class DetalleDivisionGastoDAOHibernateJPA extends GenericDAOHibernateJPA<DetalleDivisionGasto> implements DetalleDivisionGastoDAO {

	public DetalleDivisionGastoDAOHibernateJPA() {
		super(DetalleDivisionGasto.class);
	}
}
