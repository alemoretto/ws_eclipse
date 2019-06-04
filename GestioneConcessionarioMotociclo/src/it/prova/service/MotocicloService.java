package it.prova.service;

import java.util.List;

import it.prova.model.Motociclo;

public interface MotocicloService {

	public List<Motociclo> listAllMotocicli();
	
	public void aggiorna(Motociclo motocicloInstance);
	
	public void inserisciNuovo(Motociclo motocicloInstance);
	
	public void rimuovi(Motociclo motocicloInstance);

	public void refresh(Motociclo motocicloInstance);
	
	public List<Motociclo> findByExample(Motociclo motocicloInstance);
	
	public Motociclo caricaSingoloMotociclo(Long id);
	
	public Long numeroMotoTorinoPrecedenti2010();
}
