package ttps.clasesDAOImplJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ttps.clasesDAO.UsuarioDAO;
import ttps.clasesDeObjetosDelSistema.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}
	
	public Usuario recuperarPorNombreUsuario (String nom) {
		Usuario usuario = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where u.nombreUsuario = ?1", Usuario.class);
			
			query.setParameter(1, nom);
			
			usuario = (Usuario) query.getSingleResult();
			
			tx.commit();
		} catch (Exception e){
			if (tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return usuario;
	}

}
