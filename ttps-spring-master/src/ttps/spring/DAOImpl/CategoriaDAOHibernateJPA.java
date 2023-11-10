package ttps.spring.DAOImpl;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.CategoriaDAO;
import ttps.spring.model.Categoria;

@Repository
public class CategoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Categoria> implements CategoriaDAO {
	
	public CategoriaDAOHibernateJPA() {
		super(Categoria.class);
	}

}
