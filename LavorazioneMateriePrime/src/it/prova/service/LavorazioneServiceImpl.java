package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoLavorazione;

@Component
public class LavorazioneServiceImpl implements LavorazioneService {

	public void eseguiLavorazione(MateriaPrima materiaPrima) {
		
		System.out.println(materiaPrima);
		System.out.println("Sto lavorando la materia prima inserita...");
		materiaPrima.setStato(StatoLavorazione.IN_ASSEMBLAGGIO);

	}
}
