package it.prova;

public class Gallina implements Volatile {

	private String piumaggio;

	public Gallina() {
	}

	public Gallina(String piumaggio) {
		this.piumaggio = piumaggio;
	}

	public String getPiumaggio() {
		return piumaggio;
	}

	public void setPiumaggio(String piumaggio) {
		this.piumaggio = piumaggio;
	}

	@Override
	public void vola() {
		System.out.println("Io saltello");
	}

	public String stampaProprieta() {
		return piumaggio;
	}

	public boolean sonoUguali(Volatile input) {
		if (input == null || !(input instanceof Gallina))
			return false;
		return ((Gallina) input).getPiumaggio().equals(piumaggio);
	}
}
