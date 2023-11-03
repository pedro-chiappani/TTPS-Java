package ttps.spring.DAOImpl;

import ttps.spring.DAO.CategoriaDAO;
import ttps.spring.model.Categoria;

public class CategoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Categoria> implements CategoriaDAO {
	
	public CategoriaDAOHibernateJPA() {
		super(Categoria.class);
	}

}
