package it.carrello.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.carrello.model.Articolo;
import it.carrello.model.Categoria;


public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
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

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Articolo> findByExample(Articolo articoloInstance) throws Exception {
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
//		Criteria articoloCriteria = session.createCriteria(Articolo.class);
//		Example articoloExample = Example.create(articoloInstance).setPropertySelector(ps);
////		if (articoloInstance.getMunicipio() != null) {
////			articoloCriteria.createCriteria("municipio").add(Example.create(articoloInstance.getMunicipio()));
////		}
//
//		articoloCriteria.add(articoloExample);
//		return articoloCriteria.list();
//
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> findAllByCategoria(Categoria categoriaInstance) throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		Query query = entityManager.createQuery("SELECT a FROM Articolo a JOIN a.categorie c WHERE c=:cat");
		query.setParameter("cat",categoriaInstance);
		
		return query.getResultList();
		
	}

	
}
