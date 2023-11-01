package ttps.clasesDAOImplJPA;


import ttps.clasesDAO.DivisionGastoDAO;
import ttps.clasesDeObjetosDelSistema.DivisionGasto;

public class DivisionGastoDAOHibernateJPA extends GenericDAOHibernateJPA<DivisionGasto> implements DivisionGastoDAO {

	public DivisionGastoDAOHibernateJPA() {
		super(DivisionGasto.class);
	}
}
