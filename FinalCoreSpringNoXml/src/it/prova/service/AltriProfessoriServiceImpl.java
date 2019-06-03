package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.Studente;
@Component
public class AltriProfessoriServiceImpl implements AltriProfessoriService {

	@Override
	public void esaminaInAltreDiscipline(Studente studente) {
		System.out.println("Interrogazioni varie allo studente "+studente+ " effettuate...");

	}

}
