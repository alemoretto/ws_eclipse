package it.prova.gestionecartelleesattorialispringjpa.service.utente;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.model.Utente;

public interface UtenteService {
	
	public List<Utente> listAll() ;

	public Utente carica(Long id);

	public Utente caricaEager(Long id);
	
	public Utente findByUsername(String username);
	
	public void aggiorna(Utente utenteInstance);

	public void inserisci(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);
	
	public Utente eseguiAccesso(String username, String password);

	public Utente eseguiAccessoEager(String username, String password);
}
