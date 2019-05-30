package it.negozioarticolijpa.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.negozioarticolijpa.dao.EntityManagerUtil;
import it.negozioarticolijpa.dao.ArticoloDAO;
import it.negozioarticolijpa.model.Articolo;

public class ArticoloServiceImpl implements ArticoloService {
	
	private ArticoloDAO articoloDAO;
	
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

	@Override
	public List<Articolo> listAllArticoli() throws Exception {

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
	
	
}
