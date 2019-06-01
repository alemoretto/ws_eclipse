package it.carrello.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.carrello.dao.ArticoloDAO;
import it.carrello.dao.EntityManagerUtil;
import it.carrello.model.Articolo;
import it.carrello.model.Categoria;

public class ArticoloServiceImpl implements ArticoloService {

	private ArticoloDAO articoloDAO;

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

	@Override
	public List<Articolo> listAll() throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Articolo caricaSingoloElemento(Long id) throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void aggiorna(Articolo articoloInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.update(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void inserisciNuovo(Articolo articoloInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.insert(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void rimuovi(Articolo articoloInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.delete(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

//	@Override
//	public Articolo findByExample(Articolo articoloInstance) throws Exception {
//		try {
//			// uso l'injection per il dao
//			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());
//
//			// eseguo quello che realmente devo fare
//			return articoloDAO.findByExample(articoloInstance);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}

	public List<Articolo> findAllByCategoria(Categoria categoriaInstance) throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.findAllByCategoria(categoriaInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Long sommaPrezziByCategoria(Categoria categoriaInstance) throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.sommaPrezziByCategoria(categoriaInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
