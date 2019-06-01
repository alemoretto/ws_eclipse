package it.carrello.dao;

import java.util.List;

import it.carrello.model.Articolo;
import it.carrello.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo> {

	public List<Articolo> findAllByCategoria(Categoria categoriaInstance) throws Exception;

}
