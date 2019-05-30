package it.negozioarticolijpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.negozioarticolijpa.model.Negozio;

public class NegozioDAOImpl implements NegozioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Negozio> list() throws Exception {
		return entityManager.createQuery("from Negozio").getResultList();
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

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Negozio> findByExample(Negozio negozioInstance) throws Exception {
//		Session session = (Session) entityManager.getDelegate();
//
//		@SuppressWarnings("serial")
//		PropertySelector ps = new PropertySelector() {
//			@Override
//			public boolean include(Object object, String propertyName, Type type) {
//				if(object == null)
//					return false;
//				//String
//				if(object instanceof String) 
//					return StringUtils.isNotBlank((String) object);
//				//Number
//				if(object instanceof Integer)
//					return ((Integer)object) != 0;
//				return true;
//			}
//		};
//
//		Criteria abitanteCriteria = session.createCriteria(Negozio.class);
//		Example abitanteExample = Example.create(negozioInstance).setPropertySelector(ps);
//		if (negozioInstance.getMunicipio() != null) {
//			abitanteCriteria.createCriteria("municipio").add(Example.create(negozioInstance.getMunicipio()));
//		}
//
//		abitanteCriteria.add(abitanteExample);
//		return abitanteCriteria.list();
//
//	}


}
