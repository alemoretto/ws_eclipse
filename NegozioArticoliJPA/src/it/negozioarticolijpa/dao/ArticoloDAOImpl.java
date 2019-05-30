package it.negozioarticolijpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.negozioarticolijpa.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo").getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		Articolo result = (Articolo) entityManager.find(Articolo.class, id);
		return result;
	}

	@Override
	public void update(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		articoloInstance = entityManager.merge(articoloInstance);
	}

	@Override
	public void insert(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(articoloInstance);
	}

	@Override
	public void delete(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(articoloInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> findByExample(Articolo articoloInstance) throws Exception {
		Session session = (Session) entityManager.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if(object == null)
					return false;
				//String
				if(object instanceof String) 
					return StringUtils.isNotBlank((String) object);
				//Number
				if(object instanceof Integer)
					return ((Integer)object) != 0;
				return true;
			}
		};

		Criteria articoloCriteria = session.createCriteria(Articolo.class);
		Example articoloExample = Example.create(articoloInstance).setPropertySelector(ps);
		if (articoloInstance.getNegozio() != null) {
			articoloCriteria.createCriteria("negozio").add(Example.create(articoloInstance.getNegozio()));
		}

		articoloCriteria.add(articoloExample);
		return articoloCriteria.list();

	}


}
