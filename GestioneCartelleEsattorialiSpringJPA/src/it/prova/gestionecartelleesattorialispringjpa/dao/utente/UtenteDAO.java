package it.prova.gestionecartelleesattorialispringjpa.dao.utente;

import it.prova.gestionecartelleesattorialispringjpa.dao.IBaseDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente getEager(Long id);
			
	public Utente executeLogin(String username,String password);
	
	public Utente executeLoginEager(String username,String password);
	
	public Utente findByUsername(String username);
	
}
