package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ConsultaDAO {

	private EntityManager em;

	public ConsultaDAO() {
	}

	public boolean salvar(Consulta entity) {
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

	public boolean atualizar(Consulta entity) {
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
			Consulta entity = em.find(Consulta.class, id);
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

	public Consulta buscarID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Consulta entity = em.find(Consulta.class, id);
			return entity;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public List<Consulta> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Consulta> query = em.createQuery("SELECT obj FROM Consulta obj", Consulta.class);
			List<Consulta> consultas = query.getResultList();
			return consultas;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
	
}