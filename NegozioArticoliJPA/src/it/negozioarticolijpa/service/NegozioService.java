package it.negozioarticolijpa.service;

import java.util.List;

import it.negozioarticolijpa.dao.NegozioDAO;
import it.negozioarticolijpa.model.Negozio;

public interface NegozioService {
	
	public List<Negozio> listAllNegozi() throws Exception;

	public Negozio caricaSingoloNegozio(Long id) throws Exception;

	public void aggiorna(Negozio negozioInstance) throws Exception;

	public void inserisciNuovo(Negozio negozioInstance) throws Exception;

	public void rimuovi(Negozio negozioInstance) throws Exception;

	public List<Negozio> findByExample(Negozio example) throws Exception;
	
	//per injection
	public void setNegozioDAO(NegozioDAO negozioDAO);

}
