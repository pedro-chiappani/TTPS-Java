package ttps.spring.DAOImpl;

import ttps.spring.DAO.PagoDAO;
import ttps.spring.model.Pago;

public class PagoDAOHibernateJPA extends GenericDAOHibernateJPA<Pago> implements PagoDAO{

	public PagoDAOHibernateJPA() {
		super(Pago.class);
	}

}
