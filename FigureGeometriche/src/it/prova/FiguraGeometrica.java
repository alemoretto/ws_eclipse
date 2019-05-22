package it.prova;

public class FiguraGeometrica {

	protected int base;
	protected int altezza;

	public FiguraGeometrica() {
	}

	public FiguraGeometrica(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int calcolaPerimetro() {
		return -1;
	}

	public int calcolaArea() {
		return -1;
	}
}
