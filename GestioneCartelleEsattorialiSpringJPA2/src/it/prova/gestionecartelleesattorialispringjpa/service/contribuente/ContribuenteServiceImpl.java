package it.prova.gestionecartelleesattorialispringjpa.service.contribuente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionecartelleesattorialispringjpa.dao.contribuente.ContribuenteDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

@Component
public class ContribuenteServiceImpl implements ContribuenteService {

	@Autowired
	private ContribuenteDAO contribuenteDAO;

	@Transactional(readOnly = true)
	public List<Contribuente> listAll() {
		return contribuenteDAO.list();
	}

	@Transactional(readOnly = true)
	public Contribuente carica(Long id) {
		return contribuenteDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Contribuente caricaEager(Long id) {
		return contribuenteDAO.getEager(id);
	}

	@Transactional
	public void aggiorna(Contribuente utenteInstance) {
		contribuenteDAO.update(utenteInstance);
	}

	@Transactional
	public void inserisci(Contribuente utenteInstance) {
		contribuenteDAO.insert(utenteInstance);
	}

	@Transactional
	public void rimuovi(Contribuente utenteInstance) {
		contribuenteDAO.delete(utenteInstance);
	}

	@Transactional(readOnly = true)
	public List<Contribuente> findByExample(Contribuente example) {
		return contribuenteDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public List<Contribuente> cercaByDescrizioneILike(String term) {
		return contribuenteDAO.findAllByDescrizioneILike(term);
	}

}
