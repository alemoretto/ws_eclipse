package it.prova.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		CheckUp cust = context.getBean(CheckUp.class);
		
		
		cust.getCliente().setNome("per_giur");
		cust.getCliente().ordina();
		cust.setCliente(new PersonaFisica());
		cust.getCliente().setNome("per_fis");
		cust.getCliente().ordina();
		
//Cliente pf = new PersonaFisica();
//pf.setNome("per_fis");
//
//Cliente pg = new PersonaGiuridica();
//pf.setNome("per_giur");

//		cust.setCliente(cliente);
	}

}
