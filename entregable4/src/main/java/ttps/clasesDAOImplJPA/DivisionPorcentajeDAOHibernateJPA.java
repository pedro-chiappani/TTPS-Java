package ttps.clasesDAOImplJPA;


import ttps.clasesDAO.DivisionPorcentajeDAO;
import ttps.clasesDeObjetosDelSistema.DivisionPorcentaje;

public class DivisionPorcentajeDAOHibernateJPA extends GenericDAOHibernateJPA<DivisionPorcentaje> implements DivisionPorcentajeDAO {

	public DivisionPorcentajeDAOHibernateJPA() {
		super(DivisionPorcentaje.class);
	}

}
