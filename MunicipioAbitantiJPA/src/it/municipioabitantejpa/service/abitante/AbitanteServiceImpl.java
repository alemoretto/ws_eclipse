package it.municipioabitantejpa.service.abitante;

import java.util.List;

import javax.persistence.EntityManager;

import it.municipioabitantejpa.dao.EntityManagerUtil;
import it.municipioabitantejpa.dao.abitante.AbitanteDAO;
import it.municipioabitantejpa.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> listAllAbitanti() throws Exception {

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return abitanteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Abitante caricaSingoloAbitante(Long id) throws Exception {

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return abitanteDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Abitante abitanteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.update(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Abitante abitanteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.insert(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Abitante abitanteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.delete(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Abitante> findByExample(Abitante example) throws Exception {

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return abitanteDAO.findByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<Abitante> findAllByCognome(String cognome) throws Exception{
		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return abitanteDAO.findAllByCognome(cognome);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Abitante> findAllByCodiceMunicipioIniziaCon(String iniziale) throws Exception{
		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return abitanteDAO.findAllByCodiceMunicipioIniziaCon(iniziale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
