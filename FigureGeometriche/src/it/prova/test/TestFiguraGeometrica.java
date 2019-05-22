package it.prova.test;

import it.prova.*;

public class TestFiguraGeometrica {

	public static void main(String[] args) {

		int base = 2;
		int altezza = 3;

		FiguraGeometrica q = new Quadrato(base, altezza);
		FiguraGeometrica t = new Triangolo(base, altezza);
		
		// TEST Quadrato
		System.out.println("_______________________________________");
		System.out.println("Il Quadrato ha :");
		System.out.println("base = " + q.getBase());
		System.out.println("altezza = " + q.getAltezza());
		System.out.println("perimetro = " + q.calcolaPerimetro());
		System.out.println("area = " + q.calcolaArea());

		// TEST Triangolo
		System.out.println("_______________________________________");
		System.out.println("Il Triangolo ha :");
		System.out.println("base = " + t.getBase());
		System.out.println("altezza = " + t.getAltezza());
		System.out.println("perimetro = " + t.calcolaPerimetro());
		System.out.println("area = " + t.calcolaArea());
	}

}
