package it.prova.dao;

import java.util.List;

import it.prova.model.Autore;
import it.prova.model.Cd;

public interface CdDAO extends IBaseDAO<Cd> {
	
	public List<Cd> findByAutore(Autore autoreInput) throws Exception;
	
}
