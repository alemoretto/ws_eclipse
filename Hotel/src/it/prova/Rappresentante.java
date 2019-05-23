package it.prova;

public class Rappresentante extends Cliente {

	public Rappresentante() {
	}

	public Rappresentante(String nome, Stanza stanza) {
		super(nome, stanza);
	}

	public int sommaRealeDaPagare() {
		return stanza.getQuotaAPersona() * 8 / 10;
	}
}
