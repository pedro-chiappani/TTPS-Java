package ttps.spring.DAOImpl;

import ttps.spring.DAO.GenericDAO;

import java.util.List;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	protected Class<T> clasePersistente;
	private EntityManager entityManager;
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		clasePersistente = clase;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
		}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public T recuperar(Long id){
		T entity = null;
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<T> query = em.createQuery("select e from " +  getPersistentClass().getSimpleName() + " where id = ?1", clasePersistente);
			query.setParameter(1, id);
			entity = query.getSingleResult();
		}
		catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		finally {
			em.close();
		}
		return entity;
	}
	
	@Override
	public void guardar(T entity) {
		this.getEntityManager().persist(entity);
	}
	
	public Class<T> getPersistentClass(){
		return this.clasePersistente;
	}
	
	public void setPersitentClass(Class<T> clase) {
		this.clasePersistente = clase;
	}
	
	@Override
	public void actualizar(T entity) {
		EntityManager em = this.getEntityManager();
		EntityTransaction etx= em.getTransaction();
		etx.begin();
		em.merge(entity);
		etx.commit();
		em.close();
	}
	
	@Override
	public void borrar(T entity) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = null;
	 try {
		 tx = em.getTransaction();
		 tx.begin();
		 em.remove(em.merge(entity));
		 tx.commit();
	 }
	 catch (RuntimeException e) {
		 if ( tx != null && tx.isActive() ) tx.rollback();
		 throw e; // escribir en un log o mostrar un mensaje
	 } finally {
		 em.close();
	 }
	}
	
	public List<T> recuperarTodos(){
		EntityManager em = this.getEntityManager();
		Query consulta= em.createQuery("select e from "+ getPersistentClass().getSimpleName()+" e order by e.");
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}
	
}
