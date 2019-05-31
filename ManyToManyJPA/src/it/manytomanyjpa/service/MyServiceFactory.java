package it.manytomanyjpa.service;

import it.manytomanyjpa.dao.RuoloDAOImpl;
import it.manytomanyjpa.dao.UtenteDAOImpl;

public class MyServiceFactory {

	public static UtenteService getUtenteServiceInstance() {
		UtenteService utenteService = new UtenteServiceImpl();
		utenteService.setUtenteDAO(new UtenteDAOImpl());
		return utenteService;
	}

	public static RuoloService getRuoloServiceInstance() {
		RuoloService ruoloService = new RuoloServiceImpl();
		ruoloService.setRuoloDAO(new RuoloDAOImpl());
		return ruoloService;
	}

}
