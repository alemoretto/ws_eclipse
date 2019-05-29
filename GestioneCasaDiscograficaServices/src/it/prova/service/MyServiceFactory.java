package it.prova.service;

import it.prova.dao.AutoreDAOImpl;
import it.prova.dao.CasaDiscograficaDAOImpl;
import it.prova.dao.CdDAOImpl;


public class MyServiceFactory {

	public static CasaDiscograficaService getCasaDiscograficaServiceImpl() {

		CasaDiscograficaService casaDiscograficaService = new CasaDiscograficaServiceImpl();
		casaDiscograficaService.setCasaDiscograficaDAO(new CasaDiscograficaDAOImpl());
		return casaDiscograficaService;
	}

	public static AutoreService getAutoreServiceImpl() {

		
		AutoreService autoreService = new AutoreServiceImpl();
		
		autoreService.setAutoreDAO(new AutoreDAOImpl());
		autoreService.setCdDAO(new CdDAOImpl());
		return autoreService;
	}

	public static CdService getCdServiceImpl() {

		CdService cdService = new CdServiceImpl();
		cdService.setCdDAO(new CdDAOImpl());
		return cdService;
	}

}
