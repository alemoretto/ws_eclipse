package it.carrello.service;

import java.util.List;

import it.carrello.dao.ArticoloDAO;
import it.carrello.model.Articolo;
import it.carrello.model.Categoria;

public interface ArticoloService {

	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;

//	public List<Articolo> findByExample(Articolo example) throws Exception;

	public List<Articolo> findAllByCategoria(Categoria categoriaInstance) throws Exception;

	public Long sommaPrezziByCategoria(Categoria categoriaInstance) throws Exception;

	// per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);

}
