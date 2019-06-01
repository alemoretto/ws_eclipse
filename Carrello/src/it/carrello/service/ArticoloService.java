package it.carrello.service;


import java.util.List;

import it.carrello.dao.ArticoloDAO;
import it.carrello.model.Articolo;

public interface ArticoloService {

		public List<Articolo> listAll() throws Exception;

		public Articolo caricaSingoloElemento(Long id) throws Exception;

		public void aggiorna(Articolo articoloInstance) throws Exception;

		public void inserisciNuovo(Articolo articoloInstance) throws Exception;

		public void rimuovi(Articolo articoloInstance) throws Exception;

//		public List<Articolo> findByExample(Articolo example) throws Exception;

		//per injection
		public void setArticoloDAO(ArticoloDAO articoloDAO);

	}
