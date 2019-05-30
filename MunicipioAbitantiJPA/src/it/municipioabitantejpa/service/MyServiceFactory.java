package it.municipioabitantejpa.service;

import it.municipioabitantejpa.dao.MyDaoFactory;
import it.municipioabitantejpa.service.abitante.AbitanteService;
import it.municipioabitantejpa.service.abitante.AbitanteServiceImpl;
import it.municipioabitantejpa.service.municipio.MunicipioService;
import it.municipioabitantejpa.service.municipio.MunicipioServiceImpl;

public class MyServiceFactory {
	
	public static AbitanteService getAbitanteServiceInstance() {
		AbitanteService abitanteServiceInstance = new AbitanteServiceImpl();
		abitanteServiceInstance.setAbitanteDAO(MyDaoFactory.getAbitanteDAOInstance());
		return abitanteServiceInstance;
	}
	
	public static MunicipioService getMunicipioServiceInstance() {
		MunicipioService municipioServiceInstance = new MunicipioServiceImpl();
		municipioServiceInstance.setMunicipioDAO(MyDaoFactory.getMunicipioDAOInstance());
		return municipioServiceInstance;
	}

}
