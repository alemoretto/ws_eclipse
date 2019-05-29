package it.prova.service;

import java.util.List;

import it.prova.dao.CasaDiscograficaDAO;
import it.prova.model.CasaDiscografica;;

public interface CasaDiscograficaService {

	// questo mi serve per injection
	public void setCasaDiscograficaDAO(CasaDiscograficaDAO casaDiscograficaDao);

	public List<CasaDiscografica> listAllCaseDiscografiche() throws Exception;

	public CasaDiscografica findCasaById(Long idInput) throws Exception;

	public int aggiornaCasaDiscografica(CasaDiscografica input) throws Exception;

	public int inserisciNuovaCasaDiscografica(CasaDiscografica input) throws Exception;

	public int rimuoviCasaDiscografica(CasaDiscografica input) throws Exception;

	public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception;

	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale) throws Exception;
	
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere)  throws Exception;
}
