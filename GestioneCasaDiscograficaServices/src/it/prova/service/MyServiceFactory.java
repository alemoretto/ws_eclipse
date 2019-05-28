package it.prova.service;

import it.prova.dao.CasaDiscograficaDAOImpl;

public class MyServiceFactory {
	
	public static CasaDiscograficaService getCasaDiscograficaServiceImpl() {
			
			CasaDiscograficaService casaDiscograficaService = new CasaDiscograficaServiceImpl();
			casaDiscograficaService.setCasaDiscograficaDAO(new CasaDiscograficaDAOImpl());
			return casaDiscograficaService;
		}

}
