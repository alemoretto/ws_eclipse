package it.carrello.service;


import java.util.List;

import it.carrello.dao.OrdineDAO;
import it.carrello.model.Ordine;

public interface OrdineService {

		public List<Ordine> listAll() throws Exception;

		public Ordine caricaSingoloElemento(Long id) throws Exception;

		public void aggiorna(Ordine ordineInstance) throws Exception;

		public void inserisciNuovo(Ordine ordineInstance) throws Exception;

		public void rimuovi(Ordine ordineInstance) throws Exception;

//		public List<Ordine> findByExample(Ordine example) throws Exception;

		//per injection
		public void setOrdineDAO(OrdineDAO ordineDAO);

	}
