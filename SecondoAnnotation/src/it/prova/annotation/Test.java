package it.prova.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		 
		    	AgenziaNoleggio cust = (AgenziaNoleggio)context.getBean("AgenziaNoleggio");
		    	cust.getCliente().ordina();
	}
	    	
}
