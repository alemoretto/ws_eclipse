package it.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.prova.model.Motociclo;

@Component
public class MotocicloDAOImpl implements MotocicloDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Motociclo> list() {
		return entityManager.createQuery("from Motociclo").getResultList();
	}
	
	@Override
	public Motociclo get(Long id) {
		return entityManager.find(Motociclo.class, id);
	}
		
	@Override
	public void update(Motociclo motocicloInstance) {
		entityManager.merge(motocicloInstance);
	}
	
	@Override
	public void insert(Motociclo motocicloInstance) {
		entityManager.persist(motocicloInstance);
	}
	
	@Override
	public void delete(Motociclo motocicloInstance) {
		entityManager.remove(entityManager.merge(motocicloInstance));
	}
	
	@Override
	public void refresh(Motociclo motocicloInstance) {
		entityManager.refresh(entityManager.merge(motocicloInstance));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Motociclo> findByExample(Motociclo motocicloInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example motocicloExample = Example.create(motocicloInstance)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Motociclo.class).add(
				motocicloExample);
		return criteria.list();
	}
	
	@Override
	public Long numeroMotoTorinoPrecedenti2010() {
		Query q = entityManager.createQuery(
				"SELECT COUNT(m) FROM Motociclo m JOIN m.concessionario c WHERE c.citta = 'Torino' AND m.immatricolazione < 2010");
		return ((Long) q.getSingleResult());
	}
}
