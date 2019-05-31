package it.manytomanyjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;

public class UtenteDAOImpl implements UtenteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Utente").getResultList();
	}

	@Override
	public Utente get(long id) throws Exception {
		return entityManager.find(Utente.class, id);
	}

	@Override
	public void update(Utente o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(utenteInstance);
	}

	@Override
	public void delete(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(utenteInstance));
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Utente> findByExample(Utente utenteInstance) throws Exception {
//		if (utenteInstance == null) {
//			throw new Exception("Problema valore in input");
//		}
//
//		Session session = (Session) entityManager.getDelegate();
//		Example utenteExample = Example.create(utenteInstance).excludeZeroes();
//		Criteria criteria = session.createCriteria(Utente.class).add(utenteExample);
//		return criteria.list();
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> findByExample(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example utenteExample = Example.create(utenteInstance).excludeZeroes();
		Criteria criteria = session.createCriteria(Utente.class).add(utenteExample);
		return criteria.list();
	}
	// questo metodo ci torna utile per capire se possiamo rimuovere un ruolo non
	// essendo collegato ad un utente
	@SuppressWarnings("unchecked")
	public List<Utente> findAllByRuolo(Ruolo ruoloInput) {
		Query query = entityManager.createQuery("select u FROM Utente u join u.ruoli r where r.id = :ruoloId");
		query.setParameter("ruoloId", ruoloInput.getId());
		return query.getResultList();
	}

}
