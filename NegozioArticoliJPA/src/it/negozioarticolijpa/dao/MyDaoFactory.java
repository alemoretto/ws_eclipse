package it.negozioarticolijpa.dao;

import it.negozioarticolijpa.dao.*;

public class MyDaoFactory {
	
	public static NegozioDAO getNegozioDAOInstance(){
		return new NegozioDAOImpl();
	}
	
	public static ArticoloDAO getArticoloDAOInstance(){
		return new ArticoloDAOImpl();
	}

}
