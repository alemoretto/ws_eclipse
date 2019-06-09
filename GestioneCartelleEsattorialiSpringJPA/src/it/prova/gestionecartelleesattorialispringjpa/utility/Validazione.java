package it.prova.gestionecartelleesattorialispringjpa.utility;

public class Validazione {
	private boolean esito;
	private String messaggio;

	public Validazione(boolean esito, String messaggio) {
		super();
		this.esito = esito;
		this.messaggio = messaggio;
	}

	public boolean isNotValid() {
		return !esito;
	}

	public String getMessaggio() {
		return messaggio;
	}

}
