package it.prova.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		 
		    	AgenziaNoleggio cust = context.getBean(AgenziaNoleggio.class);
		    	PersonaGiuridica pg = context.getBean(PersonaGiuridica.class);
		    	pg.setNome("Pluto");
		    	cust.getCliente().ordina();
	}
	    	
}
