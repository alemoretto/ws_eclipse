package it.prova.test;

import it.prova.*;

public class TestRaccoglitore {

	public static void main(String[] args) {
		
		int numeroFogli = 3;
//		Foglio[] arrFogli = new Foglio[numeroFogli];
		Foglio f1 = new Foglio("righe");
		Foglio f2 = new Foglio("quadretti");
		Foglio f3 = new Foglio("bianco");
		Foglio[] arrFogli = {f1, f2, f3};
		
		Raccoglitore r = new Raccoglitore(arrFogli);
		System.out.println(r.getFogli().length);
		
		Foglio f4 = new Foglio("quadrettoni");
		r.addToFogli(f4);
		System.out.println(r.getFogli().length);
		
		r.removeFromFogli(1);
		System.out.println(r.getFogli().length);
		
		System.out.println();
		
	}
}
