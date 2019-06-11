package it.prova.gestionecartelleesattorialispringjpa.service.ruolo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionecartelleesattorialispringjpa.dao.ruolo.RuoloDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.Ruolo;

@Component
public class RuoloServiceImpl implements RuoloService {

	@Autowired
	private RuoloDAO ruoloDAO;

	@Transactional(readOnly = true)
	public List<Ruolo> listAll() {
		return ruoloDAO.list();
	}

	@Transactional(readOnly = true)
	public Ruolo carica(Long id) {
		return ruoloDAO.get(id);
	}

	@Transactional
	public void aggiorna(Ruolo ruoloInstance) {
		ruoloDAO.update(ruoloInstance);
	}

	@Transactional
	public void inserisci(Ruolo ruoloInstance) {
		ruoloDAO.insert(ruoloInstance);
	}

	@Transactional
	public void rimuovi(Ruolo ruoloInstance) {
		ruoloDAO.delete(ruoloInstance);
	}

	@Transactional(readOnly = true)
	public List<Ruolo> findByExample(Ruolo example) {
		return ruoloDAO.findByExample(example);
	}

}
