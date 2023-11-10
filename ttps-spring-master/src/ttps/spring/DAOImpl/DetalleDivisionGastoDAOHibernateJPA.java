package ttps.spring.DAOImpl;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.DetalleDivisionGastoDAO;
import ttps.spring.model.DetalleDivisionGasto;

@Repository
public class DetalleDivisionGastoDAOHibernateJPA extends GenericDAOHibernateJPA<DetalleDivisionGasto> implements DetalleDivisionGastoDAO {

	public DetalleDivisionGastoDAOHibernateJPA() {
		super(DetalleDivisionGasto.class);
	}
}
