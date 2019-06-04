package it.municipioabitantejpa.dao.municipio;

import it.municipioabitantejpa.model.Municipio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

@Component
public class MunicipioDAOImpl implements MunicipioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> list() {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera
		// maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Municipio").getResultList();
	}

	@Override
	public Municipio get(Long id) {
		return entityManager.find(Municipio.class, id);
	}

	@Override
	public Municipio findEagerFetch(long idMunicipio) {
		Query q = entityManager.createQuery("SELECT m FROM Municipio m JOIN FETCH m.abitanti a WHERE m.id = :id");
		q.setParameter("id", idMunicipio);
		return (Municipio) q.getSingleResult();
	}

	@Override
	public void update(Municipio municipioInstance) {
		municipioInstance = entityManager.merge(municipioInstance);
	}

	@Override
	public void insert(Municipio municipioInstance) {
		entityManager.persist(municipioInstance);
	}

	@Override
	public void delete(Municipio municipioInstance) {
		entityManager.remove(entityManager.merge(municipioInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> findByExample(Municipio municipioInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example municipioExample = Example.create(municipioInstance)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Municipio.class).add(
				municipioExample);
		return criteria.list();
	}

	@Override
	public void refresh(Municipio municipioInstance) {
		entityManager.refresh(entityManager.merge(municipioInstance));
	}

	@Override
	public Long countByAbitantiMinorenni() {
		Query q = entityManager.createQuery("SELECT count(m) from Municipio m where m in ( select distinct m from Municipio m join m.abitanti a where a.eta < 18 ) ");
		Object result =  q.getSingleResult();
		return (Long)result;
	}
	
}
