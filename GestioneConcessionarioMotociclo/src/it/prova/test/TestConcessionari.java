package it.prova.test;

import it.prova.service.BatteriaDiTestService;
import it.prova.service.MyServiceFactory;

public class TestConcessionari {
	public static void main(String[] args) {

		// DA VALORIZZARE SECONDO I CASI ESPOSTI NELLE COSTANTI SOPRA
		// ##########################################################
		
		String casoDaTestare = BatteriaDiTestService.CARICA_MOTOCICLO_LAZY;
		
		// ##########################################################

		System.out.println("################ START   #################");
		System.out.println("################ eseguo il test " + casoDaTestare + "  #################");

		MyServiceFactory.getBatteriaDiTestServiceInstance().eseguiBatteriaDiTest(casoDaTestare);

		System.out.println("################ FINE   #################");
	}
}
