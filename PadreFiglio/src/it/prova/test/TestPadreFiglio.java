package it.prova.test;

import it.prova.*;

public class TestPadreFiglio {

	public static void main(String[] args) {

		/*
		 * Padre p = new Padre(); Figlio f = new Figlio();
		 * 
		 * Padre pf2 = new Figlio();
		 * 
		 * System.out.println("metodo chiamato da Padre p = new Padre();"); p.metodo1();
		 * System.out.println("metodo chiamato da Figlio f = new Figlio();");
		 * f.metodo1();
		 * System.out.println("metodo chiamato da Padre p2 = new Figlio();");
		 * p2.metodo1();
		 */

		Padre p1 = new Padre();
		Padre p2 = new Padre();
		Padre p3 = new Figlio();
		Figlio p4 = new Figlio();
		Figlio p5 = new Figlio();
		Figlio p6 = new Figlio();
		Padre[] pArr = { p1, p2, p3, p4, p5, p6 };
		System.out.println(p1.contaQuantiPadri(pArr));
		System.out.println(p6.contaQuantiFigli(pArr));

//		Padre pf1 = new Figlio();
//		Padre pf2 = new Figlio();
//		Figlio pf3 = new Figlio();
//		Padre pf4 = new Figlio();
//		Padre[] pfArr = { pf1, pf2, pf3, pf4 };
//		System.out.println(pf3.contaQuantiFigli(pfArr));
//		
//		Padre f1 = new Padre();
//		Padre f2 = new Figlio();
//		Figlio f3 = new Figlio();
//		Padre f4 = new Figlio();
//		Padre[] fArr = { pf1, pf2, pf3, pf4 };
//		System.out.println(f3.contaQuantiFigli(fArr));

	}

}
