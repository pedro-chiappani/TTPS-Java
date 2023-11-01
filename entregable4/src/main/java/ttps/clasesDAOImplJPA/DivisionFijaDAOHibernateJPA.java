package ttps.clasesDAOImplJPA;

import ttps.clasesDAO.DivisionFijaDAO;
import ttps.clasesDeObjetosDelSistema.DivisionFija;

public class DivisionFijaDAOHibernateJPA extends GenericDAOHibernateJPA<DivisionFija> implements DivisionFijaDAO {

	public DivisionFijaDAOHibernateJPA() {
		super(DivisionFija.class);
	}

}
