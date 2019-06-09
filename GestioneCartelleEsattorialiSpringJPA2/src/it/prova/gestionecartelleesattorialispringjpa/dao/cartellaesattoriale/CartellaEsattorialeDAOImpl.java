package it.prova.gestionecartelleesattorialispringjpa.dao.cartellaesattoriale;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;

@Component
public class CartellaEsattorialeDAOImpl implements CartellaEsattorialeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> list() {
		return entityManager.createQuery("from CartellaEsattoriale").getResultList();
	}

	@Override
	public CartellaEsattoriale get(Long id) {
		return (CartellaEsattoriale) entityManager.find(CartellaEsattoriale.class, id);
	}

	@Override
	public CartellaEsattoriale getEager(Long id) {
		Query q = entityManager
				.createQuery("SELECT c from CartellaEsattoriale c JOIN FETCH c.contribuente WHERE c.id= :id");
		q.setParameter("id", id);
		return (CartellaEsattoriale) q.getSingleResult();
	}

	@Override
	public void update(CartellaEsattoriale o) {
		entityManager.merge(o);
	}

	@Override
	public void insert(CartellaEsattoriale o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(CartellaEsattoriale o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale o) {
		Session session = (Session) entityManager.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if (object == null)
					return false;
				// String
				if (object instanceof String)
					return StringUtils.isNotBlank((String) object);
				// Number
				if (object instanceof Integer)
					return ((Integer) object) != 0;
				return true;
			}
		};

		Example example = Example.create(o).setPropertySelector(ps).enableLike(MatchMode.START);
		Criteria criteria = session.createCriteria(CartellaEsattoriale.class).add(example);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartellaEsattoriale> findAllByDescrizioneILike(String term) {
		term = term != null ? term.toLowerCase() : "";
		Query query = entityManager.createQuery("select c FROM Contribuente c where lower(c.cognome) like :termInput ");
		query.setParameter("termInput", '%' + term + '%');

		return query.getResultList();
	}

}
