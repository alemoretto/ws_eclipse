package it.prova.test;

import it.prova.model.MateriaPrima;
import it.prova.service.MateriaPrimaService;
import it.prova.spring.MyServiceFactory;

public class Test {

	public static void main(String[] args) {
		MateriaPrimaService materiaPrimaService = MyServiceFactory.getMateriaPrimaService();

		MateriaPrima mat1 = materiaPrimaService.caricaMateriaPrima(1);
		System.out.println(mat1);
		
//		MateriaPrima mat2 = materiaPrimaService.caricaMateriaPrima(1);
//		System.out.println(mat2);
		
		// avvio
//		materiaPrimaService.avviaProcesso(mat1);

		
	}

}
