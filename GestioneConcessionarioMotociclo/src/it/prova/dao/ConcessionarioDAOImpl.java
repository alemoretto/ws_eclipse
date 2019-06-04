package it.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
}
