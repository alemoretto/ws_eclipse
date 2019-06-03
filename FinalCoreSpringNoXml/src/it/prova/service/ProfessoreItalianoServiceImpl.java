package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.Studente;
@Component
public class ProfessoreItalianoServiceImpl implements ProfessoreItalianoService {

	@Override
	public void esaminaInLetteratura(Studente studente) {
		System.out.println("Interrogazione di letteratura allo studente "+studente+ " effettuate...");
	}

}
