package it.prova;

public class Turista extends Cliente {

	public Turista() {
	}

	public Turista(String nome, Stanza stanza) {
		super(nome, stanza);
	}

	public int sommaRealeDaPagare() {
		return stanza.getQuotaAPersona();
	}

}
