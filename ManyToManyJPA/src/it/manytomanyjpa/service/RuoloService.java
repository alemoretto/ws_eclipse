package it.manytomanyjpa.service;

import java.util.List;

import it.manytomanyjpa.dao.RuoloDAO;
import it.manytomanyjpa.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAll() throws Exception;

	public Ruolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ruolo ruoloInstance) throws Exception;

	public void inserisciNuovo(Ruolo ruoloInstance) throws Exception;

	public void rimuovi(Ruolo ruoloInstance) throws Exception;

	public List<Ruolo> findByExample(Ruolo example) throws Exception;

	// per injection
	public void setRuoloDAO(RuoloDAO ruoloDAO);
}
