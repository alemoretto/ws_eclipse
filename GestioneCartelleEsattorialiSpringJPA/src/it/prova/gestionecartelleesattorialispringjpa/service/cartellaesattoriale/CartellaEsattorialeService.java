package it.prova.gestionecartelleesattorialispringjpa.service.cartellaesattoriale;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;

public interface CartellaEsattorialeService {

	public List<CartellaEsattoriale> listAll();

	public CartellaEsattoriale carica(Long id);

	public CartellaEsattoriale caricaEager(Long id);
	
	public void aggiorna(CartellaEsattoriale o);

	public void inserisci(CartellaEsattoriale o);

	public void rimuovi(CartellaEsattoriale o);

	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example);

}
