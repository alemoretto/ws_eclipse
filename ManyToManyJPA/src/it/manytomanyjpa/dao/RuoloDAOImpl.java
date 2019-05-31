package it.manytomanyjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;

public class RuoloDAOImpl implements RuoloDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> list() throws Exception {
		return entityManager.createQuery("from Ruolo").getResultList();
	}

	@Override
	public Ruolo get(long id) throws Exception {
		return entityManager.find(Ruolo.class, id);
	}

	@Override
	public void update(Ruolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Ruolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(o);

	}

	@Override
	public void delete(Ruolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> findByExample(Ruolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example utenteExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Utente.class).add(utenteExample);
		return criteria.list();
	}

}
