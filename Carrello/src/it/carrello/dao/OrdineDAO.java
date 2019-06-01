package it.carrello.dao;

import java.util.List;

import it.carrello.model.Categoria;
import it.carrello.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {

	public List<Ordine> findAllByCategoria(Categoria categoriaInstance) throws Exception;
	
}
