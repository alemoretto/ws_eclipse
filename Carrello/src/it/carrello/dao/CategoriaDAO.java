package it.carrello.dao;

import java.util.List;

import it.carrello.model.Categoria;
import it.carrello.model.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria> {

	public List<Categoria> findAllByOrdine(Ordine ordineInstance) throws Exception;
	
	public Long sommaPrezziByCategoria(Categoria categoriaInstance) throws Exception;
	
}
