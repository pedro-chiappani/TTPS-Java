package ttps.clasesDAOImplJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ttps.clasesDAO.UsuarioDAO;
import ttps.clasesDeObjetosDelSistema.Mensaje;
import ttps.clasesDeObjetosDelSistema.Usuario;

public class UsuarioDAOJPA implements UsuarioDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public Usuario recuperar(Long id) {
		Usuario usuario = null;
		
		try {
            em.getTransaction().begin();
            usuario = em.find(Usuario.class, id);
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

	@Override
	public List<Usuario> recuperarTodos() {
		List<Usuario> usuarios = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Usuario> query = em.createQuery("SELECT * FROM usuario", Usuario.class);
            usuarios = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return usuarios;
	}

	@Override
	public Usuario recuperarPorNombre(String unNombre) {
		Usuario usuario = null;
        try {
            em.getTransaction().begin();
            
            TypedQuery<Usuario> query = em.createQuery("SELECT * FROM usuario where nombre= ?1", Usuario.class);
            query.setParameter(1, unNombre);
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

	@Override
	public void guardar(Usuario u) {
		try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }		
	}

	@Override
	public void actualizar(Usuario u) {
		try {
            em.getTransaction().begin();
            
            Usuario usuarioExistente = em.find(Usuario.class, u.getId());
            
            if (usuarioExistente != null) {
                
            	usuarioExistente.setNombre(u.getNombre());
                
                em.merge(usuarioExistente);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
	}

	@Override
	public void borrar(Usuario u) {
		try {
            em.getTransaction().begin();
            
            Usuario usuarioExistente = em.find(Usuario.class, u.getId());
            
            if (usuarioExistente != null) {
                em.remove(usuarioExistente);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
	}

}
