package it.municipioabitantejpa.dao.municipio;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.municipioabitantejpa.model.Municipio;

public class MunicipioDAOImpl implements MunicipioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Municipio").getResultList();
	}

	@Override
	public Municipio get(Long id) throws Exception {
		return entityManager.find(Municipio.class, id);
	}

	@Override
	public void update(Municipio municipioInstance) throws Exception {
		if (municipioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		municipioInstance = entityManager.merge(municipioInstance);
	}

	@Override
	public void insert(Municipio municipioInstance) throws Exception {
		if (municipioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(municipioInstance);
	}

	@Override
	public void delete(Municipio municipioInstance) throws Exception {
		if (municipioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(municipioInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> findByExample(Municipio municipioInstance) throws Exception {
		if (municipioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example municipioExample = Example.create(municipioInstance).excludeZeroes();
		Criteria criteria = session.createCriteria(Municipio.class).add(municipioExample);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Municipio> findAllByDescrizioneIniziaCon(String inizialeDescrizione) throws Exception {
		if (inizialeDescrizione == null) {
			throw new Exception("Problema valore in input");
		}
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("SELECT m FROM Municipio m WHERE m.descrizione LIKE '" + inizialeDescrizione + "%'").getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Municipio> findAllByAbitantiMinorenni() throws Exception {
		return entityManager.createQuery(
				"SELECT m FROM Municipio m JOIN m.abitanti a WHERE a.eta < 18 GROUP BY m").getResultList();
	}
}
