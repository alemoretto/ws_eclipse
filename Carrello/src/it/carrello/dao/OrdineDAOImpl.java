package it.carrello.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.carrello.model.Categoria;
import it.carrello.model.Ordine;


public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Ordine").getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		Ordine result = (Ordine) entityManager.find(Ordine.class, id);
		return result;
	}

	@Override
	public void update(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}

		ordineInstance = entityManager.merge(ordineInstance);
	}

	@Override
	public void insert(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(ordineInstance);
	}

	@Override
	public void delete(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(ordineInstance));
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Ordine> findByExample(Ordine ordineInstance) throws Exception {
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
//		Criteria ordineCriteria = session.createCriteria(Ordine.class);
//		Example ordineExample = Example.create(ordineInstance).setPropertySelector(ps);
////		if (ordineInstance.getMunicipio() != null) {
////			ordineCriteria.createCriteria("municipio").add(Example.create(ordineInstance.getMunicipio()));
////		}
//
//		ordineCriteria.add(ordineExample);
//		return ordineCriteria.list();
//
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ordine> findAllByCategoria(Categoria categoriaInstance) throws Exception{
		Query query = entityManager.createQuery("SELECT o FROM Ordine o JOIN FETCH o.articoli a JOIN FETCH a.categorie c WHERE c=:categoria");
		query.setParameter("categoria",categoriaInstance);
		
		return query.getResultList();
	}
	
}
