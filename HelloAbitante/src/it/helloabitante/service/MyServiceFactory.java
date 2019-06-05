package it.helloabitante.service;

import it.helloabitante.dao.abitante.AbitanteDAOImpl;
import it.helloabitante.service.abitante.AbitanteService;
import it.helloabitante.service.abitante.AbitanteServiceImpl;

public class MyServiceFactory {

	public static AbitanteService getAbitanteServiceInstance() {
		AbitanteService abitanteServiceInstance = new AbitanteServiceImpl();
		abitanteServiceInstance.setAbitanteDAO(new AbitanteDAOImpl());
		return abitanteServiceInstance;
	}
}
