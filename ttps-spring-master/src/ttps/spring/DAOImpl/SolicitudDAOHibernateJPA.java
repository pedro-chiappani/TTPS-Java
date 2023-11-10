package ttps.spring.DAOImpl;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.SolicitudDAO;
import ttps.spring.model.Solicitud;


@Repository
public class SolicitudDAOHibernateJPA extends GenericDAOHibernateJPA<Solicitud> implements SolicitudDAO{

	public SolicitudDAOHibernateJPA() {
		super(Solicitud.class);
	}

}
