package it.prova.test;

import it.prova.service.CheckUpService;
import it.prova.spring.MyServiceFactory;

public class TestCheckUp {

	public static void main(String[] args) {
//		MyServiceFactory.getCheckUpService().iniziaCheckUpCompleto();
		CheckUpService cus = MyServiceFactory.getCheckUpService();
		
	}
}
