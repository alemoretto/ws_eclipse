package it.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.prova.model.Concessionario;

@Component
public class ConcessionarioDAOImpl implements ConcessionarioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Concessionario> list() {
		return entityManager.createQuery("from Concessionario").getResultList();
	}
	
	public Concessionario get(Long id) {
		return entityManager.find(Concessionario.class, id);
	}
	
	@Override
	public void update(Concessionario concessionarioInstance) {
		entityManager.merge(concessionarioInstance);
	}
	
	@Override
	public void insert(Concessionario concessionarioInstance) {
		entityManager.persist(concessionarioInstance);
	}
	
	@Override
	public void delete(Concessionario concessionarioInstance) {
		entityManager.remove(entityManager.merge(concessionarioInstance));
	}
	
	@Override
	public void refresh(Concessionario concessionarioInstance) {
		entityManager.refresh(entityManager.merge(concessionarioInstance));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Concessionario> findByExample(Concessionario concessionarioInstance) {
		Session session = (Session) entityManager.getDelegate();
		Example concessionarioExample = Example.create(concessionarioInstance)
				.excludeZeroes();
		Criteria criteria = session.createCriteria(Concessionario.class).add(
				concessionarioExample);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Concessionario> findAllConcessionariConMotociclo1200(){
		Query q = entityManager.createQuery(
				"SELECT c FROM Concessionario c JOIN c.motocicli m WHERE m.cilindrata = 1200 ORDER BY c.denominazione");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Concessionario> findAllConcessionariMilanoConHondaBetween2012And2016(){
		Query q = entityManager.createQuery(
				"SELECT c FROM Concessionario c JOIN c.motocicli m WHERE c.citta = 'Milano' AND m.marca = 'Honda' AND m.immatricolazione BETWEEN 2012 AND 2016 ORDER BY c.partitaIva");
		return q.getResultList();
	}
	
	
}
