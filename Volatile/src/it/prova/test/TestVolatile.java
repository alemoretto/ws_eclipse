package it.prova.test;

import it.prova.*;

public class TestVolatile {

	public static void main(String[] args) {

		Volatile v = new Aquila("reale");
		v.vola();
		System.out.println(v.stampaProprieta());

		v = new Gallina("piume chiare");
		v.vola();
		System.out.println(v.stampaProprieta());

		v = new Pinguino("continente antartico");
		v.vola();
		System.out.println(v.stampaProprieta());
		
		System.out.println("__________________________");
		
		Volatile v1 = new Aquila("reale");
		Volatile v2 = new Aquila("reale");
		if (v1.sonoUguali(v2))
			System.out.println("uguali");
		else
			System.out.println("diversi");
		
		v1 = new Gallina("nera");
		v2 = new Gallina("nero");
		if (v1.sonoUguali(v2))
			System.out.println("uguali");
		else
			System.out.println("diversi");

	}
}