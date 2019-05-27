package it.miopackage.jdbc.model;

public class Indirizzo {

	private Long id;
	private String citta;
	private String via;
	private String civico;

	public Indirizzo() {
		super();
	}

	public Indirizzo(String citta, String via, String civico) {
		super();
		this.citta = citta;
		this.via = via;
		this.civico = civico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", citta=" + citta + ", via=" + via + ", civico=" + civico + "]";
	}

}
