package it.prova;

public class Automobile {
	
	private Motore motore;
	private String modello;
	
	public Automobile() {
	}

	public Automobile(Motore motore) {
		this.motore = motore;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}
	public Motore getMotore() {
		return motore;
	}

	public void setMotore(Motore motore) {
		this.motore = motore;
	}
	public void mettiInMoto(){
		motore.avvia();
	}
}
