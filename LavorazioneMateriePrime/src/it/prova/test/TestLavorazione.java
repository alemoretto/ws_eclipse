package it.prova.test;

import it.prova.model.MateriaPrima;
import it.prova.service.MateriaPrimaService;
import it.prova.spring.MyServiceFactory;

public class TestLavorazione {

	public static void main(String[] args) {
		MateriaPrimaService materiaPrimaService = MyServiceFactory.getMateriaPrimaService();

		MateriaPrima materiaPrima_1 = materiaPrimaService.caricaMateriaPrima(1);
		materiaPrimaService.avviaProcesso(materiaPrima_1);

		
		System.out.println("\n###########################################\n");
		
		
		MateriaPrima materiaPrima_2 = materiaPrimaService.caricaMateriaPrima(2);
		materiaPrimaService.avviaProcesso(materiaPrima_2);

		
		System.out.println("\n###########################################\n");
		
		
		MateriaPrima materiaPrima_3 = materiaPrimaService.caricaMateriaPrima(3);
		materiaPrimaService.avviaProcesso(materiaPrima_3);

//		System.out.println(materiaPrima_1);
		// ###########################################################
		
		
//		Esame esame2 = new Esame(2,"Esame maturità geometra");
//		esameService.
//		Studente studente4 = new Studente("Matteo", "Neri",esame2);
//		esame2.addToStudenti(studente4);
		
	}

}
