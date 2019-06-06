package it.prova.service;

import java.util.List;

import it.prova.model.Persona;

public interface PersonaService {
	
	public List<Persona> listaCompleta();
	public void inserisciPersona(Persona p);
	public void aggiornaPersona(Persona p);
	public void rimuoviPersona(Persona p);
	public List<Persona> cercaPersonaByExample(Persona example);
	public Persona caricaSingolaPersona(long idPersonaInput);

}
