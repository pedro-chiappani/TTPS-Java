package ttps.spring.DAOImpl;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.DivisionGastoDAO;
import ttps.spring.model.DivisionGasto;

@Repository
public class DivisionGastoDAOHibernateJPA extends GenericDAOHibernateJPA<DivisionGasto> implements DivisionGastoDAO {

	public DivisionGastoDAOHibernateJPA() {
		super(DivisionGasto.class);
	}
}
