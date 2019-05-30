package it.negozioarticolijpa.dao;

import it.negozioarticolijpa.dao.NegozioDAO;
import it.negozioarticolijpa.dao.NegozioDAOImpl;
import it.negozioarticolijpa.dao.ArticoloDAO;
import it.negozioarticolijpa.dao.ArticoloDAOImpl;

public class MyDaoFactory {
	
	public static NegozioDAO getNegozioDAOInstance(){
		return new NegozioDAOImpl();
	}
	
	public static ArticoloDAO getArticoloDAOInstance(){
		return new ArticoloDAOImpl();
	}

}
