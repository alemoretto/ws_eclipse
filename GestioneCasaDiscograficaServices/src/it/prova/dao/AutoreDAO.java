package it.prova.dao;

import java.util.List;

import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;

public interface AutoreDAO extends IBaseDAO<Autore> {
	
	public List<Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception;
	
	public List <Autore> findByCdWhereNTracceGreaterThan(int nTracceInput) throws Exception;
		
}
