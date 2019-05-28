package it.prova.service;

import java.util.List;

import it.prova.dao.CdDAO;
import it.prova.model.Cd;

public interface CdService {

	// questo mi serve per injection
	public void setCdDAO(CdDAO cdDao);

	public List<Cd> listAllCd() throws Exception;

	public Cd findCdById(Long idInput) throws Exception;

	public int aggiornaCd(Cd input) throws Exception;

	public int inserisciNuovoCd(Cd input) throws Exception;

	public int rimuoviCd(Cd input) throws Exception;

	public List<Cd> findByExample(Cd input) throws Exception;

}
