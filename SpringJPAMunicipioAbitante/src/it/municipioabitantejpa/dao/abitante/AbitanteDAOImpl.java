package it.municipioabitantejpa.dao.abitante;

import it.municipioabitantejpa.model.Abitante;
import it.municipioabitantejpa.model.Municipio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

@Component
public class AbitanteDAOImpl implements AbitanteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> list() {
		return entityManager.createQuery("from Abitante").getResultList();
	}

	@Override
	public Abitante get(Long id) {
		return entityManager.find(Abitante.class, id);
	}

	@Override
	public void update(Abitante abitanteInstance) {
		abitanteInstance = entityManager.merge(abitanteInstance);
	}

	@Override
	public void insert(Abitante abitanteInstance) {
		entityManager.persist(abitanteInstance);
	}

	@Override
	public void delete(Abitante abitanteInstance) {
		entityManager.remove(entityManager.merge(abitanteInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abitante> findByExample(Abitante abitanteInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example abitanteExample = Example.create(abitanteInstance)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Abitante.class).add(
				abitanteExample);
		return criteria.list();
	}

	@Override
	public void refresh(Abitante abitanteInstance) {
		entityManager.refresh(entityManager.merge(abitanteInstance));
	}

	@Override
	public List<Abitante> findAllByMunicipio(Municipio input) {
		TypedQuery<Abitante> query = entityManager
				.createQuery(
						"select u FROM Abitante u JOIN FETCH u.municipio where u.municipio =:municipioInput",
						Abitante.class);
		return query.setParameter("municipioInput", input).getResultList();
	}

	@Override
	public List<Abitante> findAllByUbicazioneMunicipioContiene(
			String ubicazioneToken) {
		TypedQuery<Abitante> query = entityManager
				.createQuery(
						"select u FROM Abitante u JOIN FETCH u.municipio m where m.ubicazione like :ubicazioneInput",
						Abitante.class);
		return (List<Abitante>) query.setParameter("ubicazioneInput",
				'%' + ubicazioneToken + '%').getResultList();
	}

}
