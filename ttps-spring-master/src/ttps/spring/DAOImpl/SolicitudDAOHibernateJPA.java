package ttps.spring.DAOImpl;

import ttps.spring.DAO.SolicitudDAO;
import ttps.spring.model.Solicitud;

public class SolicitudDAOHibernateJPA extends GenericDAOHibernateJPA<Solicitud> implements SolicitudDAO{

	public SolicitudDAOHibernateJPA() {
		super(Solicitud.class);
	}

}
