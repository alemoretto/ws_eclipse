package it.carrello.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.carrello.dao.CategoriaDAO;
import it.carrello.dao.EntityManagerUtil;
import it.carrello.model.Categoria;
import it.carrello.model.Ordine;

public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDAO categoriaDAO;

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	@Override
	public List<Categoria> listAll() throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Categoria caricaSingoloElemento(Long id) throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void aggiorna(Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			categoriaDAO.update(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			categoriaDAO.insert(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	public void rimuovi(Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			categoriaDAO.delete(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	
//	@Override
//	public Categoria findByExample(Categoria categoriaInstance) throws Exception {
//		try {
//			// uso l'injection per il dao
//			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());
//
//			// eseguo quello che realmente devo fare
//			return categoriaDAO.findByExample(categoriaInstance);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}

	@Override
	public List<Categoria> findAllByOrdine(Ordine ordineInstance) throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.findAllByOrdine(ordineInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Long sommaPrezziByCategoria(Categoria categoriaInstance) throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.sommaPrezziByCategoria(categoriaInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	
}
