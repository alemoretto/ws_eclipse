package it.prova.gestionecartelleesattorialispringjpa.service.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionecartelleesattorialispringjpa.dao.utente.UtenteDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.Utente;

@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDAO utenteDAO;

	@Transactional(readOnly = true)
	public List<Utente> listAll() {
		return utenteDAO.list();
	}

	@Transactional(readOnly = true)
	public Utente carica(Long id) {
		return utenteDAO.get(id);
	}

	@Transactional
	public void aggiorna(Utente o) {
		utenteDAO.update(o);
	}

	@Transactional
	public void inserisci(Utente o) {
		utenteDAO.insert(o);
	}

	@Transactional
	public void rimuovi(Utente o) {
		utenteDAO.delete(o);
	}

	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente example) {
		return utenteDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Utente eseguiAccesso(String username, String password) {
		return utenteDAO.executeLogin(username, password);
	}

}
