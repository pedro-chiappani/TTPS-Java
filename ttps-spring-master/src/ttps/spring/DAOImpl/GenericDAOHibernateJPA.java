package ttps.spring.DAOImpl;

import ttps.spring.DAO.GenericDAO;

import java.util.List;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	protected Class<T> clasePersistente;
	
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		clasePersistente = clase;
	}
	
	public Class<T> getPersistentClass(){
		return this.clasePersistente;
	}
	
	public void setPersitentClass(Class<T> clase) {
		this.clasePersistente = clase;
	}
	
	@Override
	public T recuperar(Long id){
		T entity = null;
		try {
			this.getEntityManager().getTransaction().begin();
			TypedQuery<T> query = this.getEntityManager().createQuery("select e from " +  getPersistentClass().getSimpleName() + " where id = ?1", clasePersistente);
			query.setParameter(1, id);
			entity = query.getSingleResult();
		}
		catch (RuntimeException e) {
			if (this.getEntityManager().getTransaction().isActive()) {
				this.getEntityManager().getTransaction().rollback();
			}
		}
		finally {
			this.getEntityManager().close();
		}
		return entity;
	}
	
	@Override
	public void guardar(T entity) {
		this.getEntityManager().persist(entity);
	}
	
	@Override
	public void actualizar(T entity) {
		EntityTransaction etx= this.getEntityManager().getTransaction();
		etx.begin();
		this.getEntityManager().merge(entity);
		etx.commit();
		this.getEntityManager().close();
	}
	
	@Override
	public void borrar(T entity) {
		EntityTransaction tx = null;
	 try {
		 tx = this.getEntityManager().getTransaction();
		 tx.begin();
		 this.getEntityManager().remove(this.getEntityManager().merge(entity));
		 tx.commit();
	 }
	 catch (RuntimeException e) {
		 if ( tx != null && tx.isActive() ) tx.rollback();
		 throw e; // escribir en un log o mostrar un mensaje
	 } finally {
		 this.getEntityManager().close();
	 }
	}
	
	public List<T> recuperarTodos(){
		Query consulta= this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName()+" e ");
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}
	
}
