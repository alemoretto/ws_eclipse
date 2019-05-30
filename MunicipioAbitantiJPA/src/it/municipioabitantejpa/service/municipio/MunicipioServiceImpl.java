package it.municipioabitantejpa.service.municipio;

import java.util.List;

import javax.persistence.EntityManager;

import it.municipioabitantejpa.dao.EntityManagerUtil;
import it.municipioabitantejpa.dao.municipio.MunicipioDAO;
import it.municipioabitantejpa.model.Municipio;

public class MunicipioServiceImpl implements MunicipioService {

	private MunicipioDAO municipioDAO;

	public void setMunicipioDAO(MunicipioDAO municipioDAO) {
		this.municipioDAO = municipioDAO;
	}

	@Override
	public List<Municipio> listAllMunicipi() throws Exception {

		try {
			// uso l'injection per il dao
			municipioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return municipioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Municipio caricaSingoloMunicipio(Long id) throws Exception {

		try {
			// uso l'injection per il dao
			municipioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return municipioDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Municipio municipioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			municipioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			municipioDAO.update(municipioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Municipio municipioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			municipioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			municipioDAO.insert(municipioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Municipio municipioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			municipioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			municipioDAO.delete(municipioInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Municipio> findByExample(Municipio example) throws Exception {

		try {
			// uso l'injection per il dao
			municipioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return municipioDAO.findByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Municipio> findAllByDescrizioneIniziaCon(String inizialeDescrizione) throws Exception {

		try {
			// uso l'injection per il dao
			municipioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return municipioDAO.findAllByDescrizioneIniziaCon(inizialeDescrizione);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Municipio> findAllByAbitantiMinorenni() throws Exception {
		try {
			// uso l'injection per il dao
			municipioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return municipioDAO.findAllByAbitantiMinorenni();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
