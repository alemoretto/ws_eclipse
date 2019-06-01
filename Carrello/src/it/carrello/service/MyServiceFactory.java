package it.carrello.service;

import it.carrello.dao.*;

public class MyServiceFactory {

	public static OrdineService getOrdineServiceInstance() {
		OrdineService ordineService = new OrdineServiceImpl();
		ordineService.setOrdineDAO(new OrdineDAOImpl());
		return ordineService;
	}

	public static ArticoloService getArticoloServiceInstance() {
		ArticoloService articoloService = new ArticoloServiceImpl();
		articoloService.setArticoloDAO(new ArticoloDAOImpl());
		return articoloService;
	}

	public static CategoriaService getCategoriaServiceInstance() {
		CategoriaService categoriaService = new CategoriaServiceImpl();
		categoriaService.setCategoriaDAO(new CategoriaDAOImpl());
		return categoriaService;
	}

}
