package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.DetalleDivisionGastoDAO;
import ttps.clasesDeObjetosDelSistema.DetalleDivisionGasto;

public class DetalleDivisionGastoDAOHibernateJPA extends GenericDAOHibernateJPA<DetalleDivisionGasto> implements DetalleDivisionGastoDAO {

	public DetalleDivisionGastoDAOHibernateJPA() {
		super(DetalleDivisionGasto.class);
	}
}
