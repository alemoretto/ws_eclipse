package it.prova.model;

public class Ruolo {
	
	public static final String ADMIN_ROLE = "ADMIN_ROLE";
	public static final String CLASSIC_USER_ROLE = "CLASSIC_USER_ROLE";

	private String codice;

	public Ruolo(String codice) {
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
