package it.prova.service;

import java.util.List;

import it.prova.model.Vino;

public interface VinoService {
	
	public List<Vino> listaCompleta();
	public void inserisciVino(Vino o);
	public void aggiornaVino(Vino o);
	public void rimuoviVino(Vino o);
	public List<Vino> cercaVinoByExample(Vino example);
	public Vino caricaSingoloVino(long idVinoInput);

}
