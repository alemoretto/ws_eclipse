package it.municipioabitantejpa.dao.abitante;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.municipioabitantejpa.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> list() throws Exception {
		return entityManager.createQuery("from Abitante").getResultList();
	}

	@Override
	public Abitante get(Long id) throws Exception {
		Abitante result = (Abitante) entityManager.find(Abitante.class, id);
		return result;
	}

	@Override
	public void update(Abitante abitanteInstance) throws Exception {
		if (abitanteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		abitanteInstance = entityManager.merge(abitanteInstance);
	}

	@Override
	public void insert(Abitante abitanteInstance) throws Exception {
		if (abitanteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(abitanteInstance);
	}

	@Override
	public void delete(Abitante abitanteInstance) throws Exception {
		if (abitanteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(abitanteInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> findByExample(Abitante abitanteInstance) throws Exception {
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

		Criteria abitanteCriteria = session.createCriteria(Abitante.class);
		Example abitanteExample = Example.create(abitanteInstance).setPropertySelector(ps);
		if (abitanteInstance.getMunicipio() != null) {
			abitanteCriteria.createCriteria("municipio").add(Example.create(abitanteInstance.getMunicipio()));
		}

		abitanteCriteria.add(abitanteExample);
		return abitanteCriteria.list();

	}

	@SuppressWarnings("unchecked")
	public List<Abitante> findAllByCognome(String cognome) throws Exception{
		if (cognome == null) {
			throw new Exception("Problema valore in input");
		}
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("SELECT a FROM Abitante a WHERE a.cognome = '" + cognome + "'").getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<Abitante> findAllByCodiceMunicipioIniziaCon(String iniziale) throws Exception{
		if (iniziale == null) {
			throw new Exception("Problema valore in input");
		}
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		List<Abitante> result = entityManager.createQuery("SELECT a FROM Abitante a JOIN a.municipio m WHERE m.codice LIKE '" + iniziale + "%' ").getResultList();
	
		
		return result;
	}

}
