package it.manytomanyjpa.dao;

import java.util.List;

import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {
	
	public List<Utente> findAllByRuolo(Ruolo ruoloInput);

}
