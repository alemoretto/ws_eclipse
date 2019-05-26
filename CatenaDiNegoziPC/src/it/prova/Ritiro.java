package it.prova;

import java.util.List;
import java.util.ArrayList;

public class Ritiro {

	private Negozio negozio;
	private List<PC> pcs = new ArrayList<>();

	public Ritiro() {
	}

	public Ritiro(Negozio negozio, List<PC> pcs) {
		super();
		this.negozio = negozio;
		this.pcs = pcs;
	}

	public String toString() {
		String result = negozio.getNome() + "\n";
		for (PC pc : pcs) {
			result += pc.mostraDettagli() + "\n";
		}
		return result;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	public List<PC> getPcs() {
		return pcs;
	}

	public void setPcs(List<PC> pcs) {
		this.pcs = pcs;
	}

}
