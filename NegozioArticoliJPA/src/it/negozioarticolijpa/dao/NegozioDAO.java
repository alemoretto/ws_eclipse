package it.negozioarticolijpa.dao;

import java.util.List;

import it.negozioarticolijpa.model.Negozio;

public interface NegozioDAO extends IBaseDAO<Negozio> {
	
	public List<Negozio> orderByNumeroArticoli() throws Exception;

}


