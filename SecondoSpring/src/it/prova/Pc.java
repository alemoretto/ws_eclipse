package it.prova;

public class Pc {
	private Stampante stampante;

	public Stampante getStampante() {
		return stampante;
	}

	public void setStampante(Stampante stampante) {
		this.stampante = stampante;
	}
	
	public void effettuaStampa(){
		stampante.stampa();
	}
}
