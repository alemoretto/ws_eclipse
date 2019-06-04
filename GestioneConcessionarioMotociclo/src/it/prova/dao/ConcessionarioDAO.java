package it.prova.dao;

import java.util.List;

import it.prova.model.Concessionario;

public interface ConcessionarioDAO extends IBaseDAO<Concessionario> {

	public List<Concessionario> list();
	
}
