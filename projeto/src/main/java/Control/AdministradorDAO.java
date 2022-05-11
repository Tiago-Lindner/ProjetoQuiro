package Control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Administrador;

public class AdministradorDAO {
    private EntityManager em;

	public AdministradorDAO() {
	}

	public boolean salvar(Administrador entity) {
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

	public boolean atualizar(Administrador entity) {
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
			Administrador entity = em.find(Administrador.class, id);
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

	public Administrador buscarID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Administrador entity = em.find(Administrador.class, id);
			return entity;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public List<Administrador> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Administrador> query = em.createQuery("SELECT obj FROM Administrador obj", Administrador.class);
			List<Administrador> adms = query.getResultList();
			return adms;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
}
