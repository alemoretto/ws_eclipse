package it.municipioabitantejpa.dao;

import it.municipioabitantejpa.dao.abitante.AbitanteDAO;
import it.municipioabitantejpa.dao.abitante.AbitanteDAOImpl;
import it.municipioabitantejpa.dao.municipio.MunicipioDAO;
import it.municipioabitantejpa.dao.municipio.MunicipioDAOImpl;

public class MyDaoFactory {
	
	public static AbitanteDAO getAbitanteDAOInstance(){
		return new AbitanteDAOImpl();
	}
	
	public static MunicipioDAO getMunicipioDAOInstance(){
		return new MunicipioDAOImpl();
	}

}
