package it.prova.dao;

import java.util.List;

import it.prova.model.CasaDiscografica;

public interface CasaDiscograficaDAO extends IBaseDAO<CasaDiscografica> {

	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale)  throws Exception;
	
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere)  throws Exception;
	
}
