package it.prova.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.prova.service.ElettricistaService;
import it.prova.service.ImpresaRistrutturazioneService;

public class MyServiceFactory {

	private static ApplicationContext ctx;

	static {
		try {
			ctx = new ClassPathXmlApplicationContext("beans.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ImpresaRistrutturazioneService getImpresaRistrutturazioneService() {
		return (ImpresaRistrutturazioneService) ctx.getBean("ImpresaRistrutturazioneService");
	}
	
	public static ElettricistaService getElettricistaService(){
		return (ElettricistaService) ctx.getBean("ElettricistaService");
	}
}
