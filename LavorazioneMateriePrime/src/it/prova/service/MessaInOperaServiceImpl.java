package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoLavorazione;

@Component
public class MessaInOperaServiceImpl implements MessaInOperaService {

	public void eseguiMessaInOpera(MateriaPrima materiaPrima) {

		System.out.println(materiaPrima);
		System.out.println("Metto in opera la materia prima verniciata...");
		materiaPrima.setStato(StatoLavorazione.PRONTA);

	}

}
