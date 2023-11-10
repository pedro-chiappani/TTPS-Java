package ttps.spring.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;


@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}
	
	public Usuario recuperarNomPass(String nom, String pass) {
		
		EntityTransaction tx = null;
		
		Usuario us = null;
		try {
			tx = this.getEntityManager().getTransaction();
			tx.begin();
			
			TypedQuery<Usuario> query = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE nombreUsuario = ?1 AND clave = ?2", Usuario.class);
			
			query.setParameter(1, nom);
			query.setParameter(2, pass);
			
			us = (Usuario) query.getSingleResult();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;
		} finally {
			this.getEntityManager().close();
		}
		return us;
	}
	
	public Usuario recuperarPorNombreUsuario (String nom) {
		Usuario usuario = null;
		EntityTransaction tx = null;
		try {
			tx = this.getEntityManager().getTransaction();
			tx.begin();
			
			TypedQuery<Usuario> query = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE nombreUsuario = ?1", Usuario.class);
			
			query.setParameter(1, nom);
			
			usuario = (Usuario) query.getSingleResult();
			
			tx.commit();
		} catch (Exception e){
			if (tx.isActive())
				tx.rollback();
			e.printStackTrace();
		} finally {
			this.getEntityManager().close();
		}
		return usuario;
	}

}
