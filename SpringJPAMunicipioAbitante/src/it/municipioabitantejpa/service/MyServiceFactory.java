package it.municipioabitantejpa.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServiceFactory {
	
	private static ApplicationContext ctx;

	static {
		try {
			ctx = new ClassPathXmlApplicationContext("spring.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BatteriaDiTestService getBatteriaDiTestServiceInstance() {
		return ctx.getBean(BatteriaDiTestService.class);
	}
	
}
