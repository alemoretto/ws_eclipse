package it.prova;

public class Foglio {

	private String tipologia;
	private String qualita;

	public Foglio() {
	}

	public Foglio(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getQualita() {
		return qualita;
	}

	public void setQualita(String qualita) {
		this.qualita = qualita;
	}

}
