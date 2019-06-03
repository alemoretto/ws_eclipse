package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.Studente;
@Component
public class ProfessoreMatematicaServiceImpl implements
		ProfessoreMatematicaService {

	@Override
	public void esaminaInMatematica(Studente studente) {
		System.out.println("Interrogazioni di matematica allo studente "+studente+ " effettuate...");
	}

}
