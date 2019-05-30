package it.negozioarticolijpa.test;

import it.negozioarticolijpa.service.ArticoloService;
import it.negozioarticolijpa.service.MyServiceFactory;
import it.negozioarticolijpa.service.NegozioService;

public class Test {

	public static void main(String[] args) {

		NegozioService negozioService = MyServiceFactory.getNegozioServiceInstance();
		ArticoloService articoloService = MyServiceFactory.getArticoloServiceInstance();

		try {
			
			negozioService.listAllNegozi();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}