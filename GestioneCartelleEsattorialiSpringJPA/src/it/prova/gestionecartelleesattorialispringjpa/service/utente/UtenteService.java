package it.prova.gestionecartelleesattorialispringjpa.service.utente;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.model.Utente;

public interface UtenteService {

	public List<Utente> listAll();

	public Utente carica(Long id);

	public void aggiorna(Utente o);

	public void inserisci(Utente o);

	public void rimuovi(Utente o);

	public List<Utente> findByExample(Utente example);

	public Utente eseguiAccesso(String username, String password);

}
