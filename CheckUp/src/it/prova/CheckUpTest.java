package it.prova;

import it.prova.service.CheckUpService;
import it.prova.service.EmatologoService;
import it.prova.service.OrtopedicoService;
import it.prova.service.RadiologoService;
import it.prova.spring.MyServiceFactory;

public class CheckUpTest {

	public static void main(String[] args) {
//		MyServiceFactory.getCheckUpService().iniziaCheckUpCompleto();
		CheckUpService cus = MyServiceFactory.getCheckUpService();
		
		cus.iniziaCheckUpCompleto();
//		OrtopedicoService ort = MyServiceFactory.getCheckUpService().getOrtopedicoService();
//		OrtopedicoService ort2 = MyServiceFactory.getCheckUpService().getOrtopedicoService();
//		System.out.println(ort.getNome());
//		ort2.setNome("mario");
//		System.out.println(ort2.getNome());
		
//		ort = null;
//		ort = cus.getOrtopedicoService();
//		System.out.println(ort.getNome());
		
	}
}
