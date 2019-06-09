package it.prova.gestionecartelleesattorialispringjpa.service.contribuente;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

public interface ContribuenteService {

	public List<Contribuente> listAll();

	public Contribuente carica(Long id);

	public Contribuente caricaEager(Long id);

	public void aggiorna(Contribuente o);

	public void inserisci(Contribuente o);

	public void rimuovi(Contribuente o);

	public List<Contribuente> findByExample(Contribuente example);

	public List<Contribuente> cercaByDescrizioneILike(String term);

}
