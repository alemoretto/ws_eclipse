package it.carrello.service;


import java.util.List;

import it.carrello.dao.CategoriaDAO;
import it.carrello.model.Categoria;

public interface CategoriaService {

		public List<Categoria> listAll() throws Exception;

		public Categoria caricaSingoloElemento(Long id) throws Exception;

		public void aggiorna(Categoria categoriaInstance) throws Exception;

		public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

		public void rimuovi(Categoria categoriaInstance) throws Exception;

//		public List<Categoria> findByExample(Categoria example) throws Exception;

		//per injection
		public void setCategoriaDAO(CategoriaDAO categoriaDAO);

	}
