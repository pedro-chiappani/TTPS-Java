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
		
		EntityManager emm = this.getEntityManager();
		EntityTransaction tx = null;
		
		Usuario us = null;
		try {
			tx = emm.getTransaction();
			tx.begin();
			
			TypedQuery<Usuario> query = emm.createQuery("SELECT u FROM Usuario u WHERE nombreUsuario = ?1 AND clave = ?2", Usuario.class);
			
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
			emm.close();
		}
		return us;
	}
	
	public Usuario recuperarPorNombreUsuario (String nom) {
		Usuario usuario = null;
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE nombreUsuario = ?1", Usuario.class);
			
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
