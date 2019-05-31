package it.manytomanyjpa.service;

import java.util.List;

import it.manytomanyjpa.dao.UtenteDAO;
import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;

public interface UtenteService  {
	
	public List<Utente> listAll() throws Exception;

	public Utente caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Utente utenteInstance) throws Exception;

	public void inserisciNuovo(Utente utenteInstance) throws Exception;

	public void rimuovi(Utente utenteInstance) throws Exception;

	public List<Utente> findByExample(Utente example) throws Exception;

	public List<Utente> findAllByRuolo(Ruolo ruoloInput) throws Exception;
	
	//per injection
	public void setUtenteDAO(UtenteDAO utenteDAO);

}
