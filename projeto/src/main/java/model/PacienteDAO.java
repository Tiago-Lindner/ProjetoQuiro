package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PacienteDAO {

	private EntityManager em;

	public PacienteDAO() {
	}

	public boolean salvar(Paciente entity) {
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

	public boolean atualizar(Paciente entity) {
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
			Paciente entity = em.find(Paciente.class, id);
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

	public Paciente buscarID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Paciente entity = em.find(Paciente.class, id);
			return entity;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public List<Paciente> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Paciente> query = em.createQuery("SELECT obj FROM Paciente obj", Paciente.class);
			List<Paciente> pacientes = query.getResultList();
			return pacientes;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
	
}
