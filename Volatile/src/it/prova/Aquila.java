package it.prova;

public class Aquila implements Volatile {

	private String razzaAquila;

	public Aquila() {
	}

	public Aquila(String razzaAquila) {
		this.razzaAquila = razzaAquila;
	}

	public String getRazzaAquila() {
		return razzaAquila;
	}

	public void setRazzaAquila(String razzaAquila) {
		this.razzaAquila = razzaAquila;
	}

	@Override
	public void vola() {
		System.out.println("Sto volando");
	}

	public String stampaProprieta() {
		return razzaAquila;
	}

	public boolean sonoUguali(Volatile input) {
		if (input == null || !(input instanceof Aquila))
			return false;
		return ((Aquila) input).getRazzaAquila().equals(razzaAquila);
	}
}
