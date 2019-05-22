package it.prova;

public class Pinguino implements Volatile {

	private String continenteAppartenenza;

	public Pinguino() {
	}

	public Pinguino(String continenteAppartenenza) {
		this.continenteAppartenenza = continenteAppartenenza;
	}

	public String getContinenteAppartenenza() {
		return continenteAppartenenza;
	}

	public void setContinenteAppartenenza(String continenteAppartenenza) {
		this.continenteAppartenenza = continenteAppartenenza;
	}

	@Override
	public void vola() {
		System.out.println("Io non so volare");
	}

	public String stampaProprieta() {
		return continenteAppartenenza;
	}

	public boolean sonoUguali(Volatile input) {
		if (input == null || !(input instanceof Pinguino))
			return false;
		return input.stampaProprieta().equals(stampaProprieta());
	}
}
