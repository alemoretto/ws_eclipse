package it.prova.service;

import it.prova.model.Esame;
import it.prova.model.Studente;

public interface EsameService {
	public Esame caricaEsame(int id);
	public void avviaEsame(Esame esame);
	public void aggiungiStudenteAdEsame(Studente studenteInput, Esame esameInput);
	
	public void avviaEsameByStudente(Esame esame, Studente studente);
}
