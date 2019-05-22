package it.prova;

public class Quadrato extends FiguraGeometrica {

	public Quadrato() {
	}

	public Quadrato(int base, int altezza) {
		super(base, altezza);
	}

	public int calcolaPerimetro() {
		return 2 * (base + altezza);
	}

	public int calcolaArea() {
		return base * altezza;
	}
}
