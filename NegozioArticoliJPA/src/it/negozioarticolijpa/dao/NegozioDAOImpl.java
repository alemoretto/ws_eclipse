package it.negozioarticolijpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.negozioarticolijpa.model.Negozio;

public class NegozioDAOImpl implements NegozioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> list() throws Exception {
		return entityManager.createQuery(" from Negozio ").getResultList();
	}

	@Override
	public Negozio get(Long id) throws Exception {
		Negozio result = (Negozio) entityManager.find(Negozio.class, id);
		return result;
	}

	@Override
	public void update(Negozio negozioInstance) throws Exception {
		if (negozioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		negozioInstance = entityManager.merge(negozioInstance);
	}

	@Override
	public void insert(Negozio negozioInstance) throws Exception {
		if (negozioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(negozioInstance);
	}

	@Override
	public void delete(Negozio negozioInstance) throws Exception {
		if (negozioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(negozioInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> findByExample(Negozio negozioInstance) throws Exception {
		if (negozioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example negozioExample = Example.create(negozioInstance).  excludeZeroes();
		Criteria criteria = session.createCriteria(Negozio.class).add(negozioExample);
		return criteria.list();
	}

	public List<Negozio> orderByNumeroArticoli() throws Exception {
//		SELECT negozio.* , count(articolo.negozio_id) as c FROM negozio
//		LEFT JOIN articolo ON articolo.negozio_id=negozio.id group by negozio.id;
		return entityManager.createQuery(
				" SELECT Negozio.*,count(Articolo.negozio) as c FROM negozio\r\n" + 
				"//		LEFT JOIN articolo ON articolo.negozio_id=negozio.id group by negozio.id  ").getResultList();
	}
	
}
