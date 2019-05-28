package it.prova.service;

import java.util.List;

import it.prova.dao.AutoreDAO;
import it.prova.model.Autore;

public interface AutoreService {

	// questo mi serve per injection
	public void setAutoreDAO(AutoreDAO autoreDao);

	public List<Autore> listAllAutori() throws Exception;

	public Autore findAutoreById(Long idInput) throws Exception;

	public int aggiornaAutore(Autore input) throws Exception;

	public int inserisciNuovoAutore(Autore input) throws Exception;

	public int rimuoviAutore(Autore input) throws Exception;

	public List<Autore> findByExample(Autore input) throws Exception;

}
