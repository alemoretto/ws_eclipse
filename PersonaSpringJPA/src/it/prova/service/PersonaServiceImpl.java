package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.PersonaDAO;
import it.prova.model.Persona;

@Component
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> listaCompleta(){
		return personaDAO.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> cercaPersonaByExample(Persona example) {
		return personaDAO.findByExample(example);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona caricaSingolaPersona(long idPersonaInput) {
		return personaDAO.get(idPersonaInput);
	}

	@Override
	@Transactional
	public void inserisciPersona(Persona p) {
		personaDAO.insert(p);
	}

	@Override
	@Transactional
	public void aggiornaPersona(Persona p) {
		personaDAO.update(p);
	}

	@Override
	@Transactional
	public void rimuoviPersona(Persona p) {
		personaDAO.delete(p);
	}

	
}
