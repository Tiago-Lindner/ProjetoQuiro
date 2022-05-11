package Control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Telefone;

public class TelefoneDAO {

	private EntityManager em;

	public TelefoneDAO() {
	}

	public boolean salvar(Telefone entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean atualizar(Telefone entity) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}

	public boolean remover(long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Telefone entity = em.find(Telefone.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}

	public Telefone buscarID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Telefone entity = em.find(Telefone.class, id);
			return entity;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public List<Telefone> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Telefone> query = em.createQuery("SELECT obj FROM Telefone obj", Telefone.class);
			List<Telefone> telefones = query.getResultList();
			return telefones;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
	
}
