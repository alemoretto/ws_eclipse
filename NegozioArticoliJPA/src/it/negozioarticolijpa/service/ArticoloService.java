package it.negozioarticolijpa.service;

import java.util.List;

import it.negozioarticolijpa.dao.ArticoloDAO;
import it.negozioarticolijpa.model.Articolo;

public interface ArticoloService {
	
	public List<Articolo> listAllArticoli() throws Exception;

	public Articolo caricaSingoloArticolo(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;

	public List<Articolo> findByExample(Articolo example) throws Exception;
	
	//per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);

}
