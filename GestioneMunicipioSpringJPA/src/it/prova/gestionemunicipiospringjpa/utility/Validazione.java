package it.prova.gestionemunicipiospringjpa.utility;

public class Validazione {
	private boolean esito;
	private String messaggio;
	
	public Validazione(boolean esito, String messaggio) {
		super();
		this.esito = esito;
		this.messaggio = messaggio;
	}

	public boolean getEsito() {
		return esito;
	}

	public void setEsito(boolean esito) {
		this.esito = esito;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
}
