package it.prova;

public class Triangolo extends FiguraGeometrica {

	public Triangolo() {}
	
	public Triangolo(int base, int altezza) {
		super(base, altezza);
	}
	
	public int calcolaPerimetro() {
		return 3 * base;
	}
	
	public int calcolaArea() {
		return base * altezza / 2;
	}
}
