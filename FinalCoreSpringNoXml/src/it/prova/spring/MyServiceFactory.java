package it.prova.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.prova.service.EsameService;

public class MyServiceFactory {

	private static ApplicationContext ctx;

	static {
		try {
			ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EsameService getEsameService() {
		return  ctx.getBean(EsameService.class);
	}
}
