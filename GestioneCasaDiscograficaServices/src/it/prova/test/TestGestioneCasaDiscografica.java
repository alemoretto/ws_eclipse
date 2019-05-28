package it.prova.test;

import java.util.Date;

import it.prova.model.CasaDiscografica;
import it.prova.service.MyServiceFactory;
import it.prova.service.CasaDiscograficaService;

public class TestGestioneCasaDiscografica {

	public static void main(String[] args) {
//		CasaDiscografica newCasaInstance = new CasaDiscografica("mauro", "rossi");
//		newCasaInstance.setDateCreated(new Date());

		//parlo direttamente con il service
		CasaDiscograficaService casaService = MyServiceFactory.getCasaDiscograficaServiceImpl();

		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			System.out.println("#########  lista tutte le CASE ##########");
			System.out.println("In tabella ci sono " + casaService.listAllCaseDiscografiche().size() + " elementi.");
			for (CasaDiscografica casa : casaService.listAllCaseDiscografiche()) {
				System.out.println(casa);
				
			}
//			userService.inserisciNuovoUser(newUserInstance);
//			User founded = userService.findUserById(2L);
//			System.out.println("User con id 2 "+founded);
//			userService.rimuoviUser(founded);
//			System.out.println("In tabella ci sono " + userService.listAllUsers().size() + " elementi.");
//
//			User example = new User();
//			example.setNome("Mario");
//			System.out.println(
//					"In tabella ci sono " + userService.findByExample(example).size() + " " + example.getNome());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
