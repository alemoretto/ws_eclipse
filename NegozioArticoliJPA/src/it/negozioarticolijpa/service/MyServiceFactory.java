package it.negozioarticolijpa.service;

import it.negozioarticolijpa.dao.MyDaoFactory;
import it.negozioarticolijpa.service.NegozioService;
import it.negozioarticolijpa.service.NegozioServiceImpl;
import it.negozioarticolijpa.service.ArticoloService;
import it.negozioarticolijpa.service.ArticoloServiceImpl;

public class MyServiceFactory {
	
	public static NegozioService getNegozioServiceInstance() {
		NegozioService negozioServiceInstance = new NegozioServiceImpl();
		negozioServiceInstance.setNegozioDAO(MyDaoFactory.getNegozioDAOInstance());
		return negozioServiceInstance;
	}
	
	public static ArticoloService getArticoloServiceInstance() {
		ArticoloService articoloServiceInstance = new ArticoloServiceImpl();
		articoloServiceInstance.setArticoloDAO(MyDaoFactory.getArticoloDAOInstance());
		return articoloServiceInstance;
	}

}
