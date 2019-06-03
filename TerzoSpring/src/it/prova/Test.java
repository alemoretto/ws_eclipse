package it.prova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		
		Automobile auto = (Automobile) context.getBean("autoBean");
		auto.mettiInMoto();

	}

}
