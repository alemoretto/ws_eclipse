package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.VinoDAO;
import it.prova.model.Vino;

@Component
public class VinoServiceImpl implements VinoService {

	@Autowired
	private VinoDAO vinoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Vino> listaCompleta(){
		return vinoDAO.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vino> cercaVinoByExample(Vino example) {
		return vinoDAO.findByExample(example);
	}

	@Override
	@Transactional(readOnly = true)
	public Vino caricaSingoloVino(long idPersonaInput) {
		return vinoDAO.get(idPersonaInput);
	}

	@Override
	@Transactional
	public void inserisciVino(Vino p) {
		vinoDAO.insert(p);
	}

	@Override
	@Transactional
	public void aggiornaVino(Vino p) {
		vinoDAO.update(p);
	}

	@Override
	@Transactional
	public void rimuoviVino(Vino p) {
		vinoDAO.delete(p);
	}

	
}
