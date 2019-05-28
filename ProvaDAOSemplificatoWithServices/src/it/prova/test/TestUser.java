package it.prova.test;

import java.util.Date;

import it.prova.model.User;
import it.prova.service.MyServiceFactory;
import it.prova.service.user.UserService;

public class TestUser {

	public static void main(String[] args) {
		User newUserInstance = new User("mauro", "rossi", "avavv", "bobobo");
		newUserInstance.setDateCreated(new Date());

		//parlo direttamente con il service
		UserService userService = MyServiceFactory.getUserServiceImpl();

		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			System.out.println("In tabella ci sono " + userService.listAllUsers().size() + " elementi.");
			userService.inserisciNuovoUser(newUserInstance);
			User founded = userService.findUserById(2L);
			System.out.println("User con id 2 "+founded);
			userService.rimuoviUser(founded);
			System.out.println("In tabella ci sono " + userService.listAllUsers().size() + " elementi.");

			User example = new User();
			example.setNome("Mario");
			System.out.println(
					"In tabella ci sono " + userService.findByExample(example).size() + " " + example.getNome());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
