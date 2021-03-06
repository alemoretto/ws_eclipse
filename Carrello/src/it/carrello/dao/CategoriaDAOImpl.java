package it.carrello.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.carrello.model.Categoria;
import it.carrello.model.Ordine;


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

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllByOrdine(Ordine ordineInstance) throws Exception{
		Query query = entityManager.createQuery("SELECT c FROM Categoria c JOIN FETCH c.articoli a JOIN FETCH a.ordine o WHERE o=:ordine GROUP BY c");
		query.setParameter("ordine",ordineInstance);
		
		return query.getResultList();
	}
	
	@Override
	public Long sommaPrezziByCategoria(Categoria categoriaInstance) throws Exception {
		Query query = entityManager
				.createQuery("SELECT SUM(a.prezzoSingolo) FROM Articolo a JOIN a.categorie c WHERE c=:categoria");
		query.setParameter("categoria", categoriaInstance);

		return ((Long) query.getSingleResult());
	}

	
}
