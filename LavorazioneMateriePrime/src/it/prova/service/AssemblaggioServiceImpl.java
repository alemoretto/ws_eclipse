package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoLavorazione;

@Component 
public class AssemblaggioServiceImpl implements AssemblaggioService {

	public void eseguiAssemblaggio(MateriaPrima materiaPrima) {

		System.out.println(materiaPrima);
		System.out.println("Sto assemblando la materia prima lavorata...");
		materiaPrima.setStato(StatoLavorazione.IN_VERNICIATURA);

	}

}
