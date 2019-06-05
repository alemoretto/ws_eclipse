package it.prova.service;

import java.util.List;

import it.prova.model.Concessionario;

public interface ConcessionarioService {

	public List<Concessionario> listAllConcessionari();

	public List<Concessionario> listAllConcessionariEager();
	
	public Concessionario caricaSingoloConcessionarioLazy(Long id);	
	
	public Concessionario caricaSingoloConcessionarioEager(Long id);
	
	public void aggiorna(Concessionario concessionarioInstance);
	
	public void inserisciNuovo(Concessionario concessionarioInstance);

	public void rimuovi(Concessionario concessionarioInstance);
	
	public void refresh(Concessionario concessionarioInstance);
	
	public List<Concessionario> findByExample(Concessionario concessionarioInstance);
	
	public List<Concessionario> findAllConcessionariConMotociclo1200();
	
	public List<Concessionario> findAllConcessionariMilanoConHondaBetween2012And2016();
	
}
