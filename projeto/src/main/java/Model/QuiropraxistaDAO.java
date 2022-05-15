package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class QuiropraxistaDAO {

	private EntityManager em;

	public QuiropraxistaDAO() {
	}

	public boolean salvar(Quiropraxista entity) {
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

	public boolean atualizar(Quiropraxista entity) {
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
			Quiropraxista entity = em.find(Quiropraxista.class, id);
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

	public Quiropraxista buscarID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Quiropraxista entity = em.find(Quiropraxista.class, id);
			return entity;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public List<Quiropraxista> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Quiropraxista> query = em.createQuery("SELECT obj FROM Pessoa obj", Quiropraxista.class);
			List<Quiropraxista> quiros = query.getResultList();
			return quiros;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
	
}
