package it.prova.gestionecartelleesattorialispringjpa.service.ruolo;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.model.Ruolo;

public interface RuoloService {

	public List<Ruolo> listAll();

	public Ruolo carica(Long id);

	public void aggiorna(Ruolo ruoloInstance);

	public void inserisci(Ruolo ruoloInstance);

	public void rimuovi(Ruolo ruoloInstance);

	public List<Ruolo> findByExample(Ruolo example);

}
