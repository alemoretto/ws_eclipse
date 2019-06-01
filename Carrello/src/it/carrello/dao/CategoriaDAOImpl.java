package it.carrello.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.carrello.model.Categoria;


public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Categoria").getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		Categoria result = (Categoria) entityManager.find(Categoria.class, id);
		return result;
	}

	@Override
	public void update(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		categoriaInstance = entityManager.merge(categoriaInstance);
	}

	@Override
	public void insert(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(categoriaInstance);
	}

	@Override
	public void delete(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(categoriaInstance));
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Categoria> findByExample(Categoria categoriaInstance) throws Exception {
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
//		Criteria categoriaCriteria = session.createCriteria(Categoria.class);
//		Example categoriaExample = Example.create(categoriaInstance).setPropertySelector(ps);
////		if (categoriaInstance.getMunicipio() != null) {
////			categoriaCriteria.createCriteria("municipio").add(Example.create(categoriaInstance.getMunicipio()));
////		}
//
//		categoriaCriteria.add(categoriaExample);
//		return categoriaCriteria.list();
//
//	}


	
}
