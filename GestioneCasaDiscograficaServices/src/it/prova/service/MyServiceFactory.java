package it.prova.service;

import it.prova.dao.CasaDiscograficaDAOImpl;
import it.prova.dao.AutoreDAOImpl;

public class MyServiceFactory {

	public static CasaDiscograficaService getCasaDiscograficaServiceImpl() {

		CasaDiscograficaService casaDiscograficaService = new CasaDiscograficaServiceImpl();
		casaDiscograficaService.setCasaDiscograficaDAO(new CasaDiscograficaDAOImpl());
		return casaDiscograficaService;
	}

	public static AutoreService getAutoreServiceImpl() {

		AutoreService autoreService = new AutoreServiceImpl();
		autoreService.setAutoreDAO(new AutoreDAOImpl());
		return autoreService;
	}

}
