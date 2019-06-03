package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoLavorazione;

@Component
public class VerniciaturaServiceImpl implements VerniciaturaService {

	public void eseguiVerniciatura(MateriaPrima materiaPrima) {
		System.out.println(materiaPrima);
		System.out.println("Sto verniciando la materia prima assemblata...");
		materiaPrima.setStato(StatoLavorazione.IN_MESSA_IN_OPERA);

	}
}
