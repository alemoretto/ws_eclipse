package it.prova.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {
	
	@Autowired
	private Person persona;

	public Person getPersona() {
		return persona;
	}

	//il set non è necessario
	
}
