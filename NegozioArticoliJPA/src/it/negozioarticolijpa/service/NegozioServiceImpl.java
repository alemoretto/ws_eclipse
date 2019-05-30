package it.negozioarticolijpa.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.negozioarticolijpa.dao.EntityManagerUtil;
import it.negozioarticolijpa.dao.NegozioDAO;
import it.negozioarticolijpa.model.Negozio;

public class NegozioServiceImpl implements NegozioService {
	
	private NegozioDAO negozioDAO;
	
	public void setNegozioDAO(NegozioDAO negozioDAO) {
		this.negozioDAO = negozioDAO;
	}

	@Override
	public List<Negozio> listAllNegozi() throws Exception {

		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return negozioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
}
