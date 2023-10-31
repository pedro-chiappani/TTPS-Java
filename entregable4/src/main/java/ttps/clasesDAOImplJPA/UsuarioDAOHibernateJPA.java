package ttps.clasesDAOImplJPA;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ttps.clasesDAO.UsuarioDAO;
import ttps.clasesDeObjetosDelSistema.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	private EntityManager em = EMF.getEMF().createEntityManager();
	
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}
	
	public Usuario recuperarPorNombreUsuario(String unNombreUsuario) {
		Usuario usuario = null;
        try {
            em.getTransaction().begin();
            
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where nombreUsuario= ?1", Usuario.class);
            query.setParameter(1, unNombreUsuario);
            usuario = query.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return usuario;
	}

}
