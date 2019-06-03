package it.prova.model;

public class MateriaPrima {

	private int id;
	private String descrizione;
	private StatoLavorazione stato;
	
	public MateriaPrima() {
	}

	public MateriaPrima(int id, String descrizione,StatoLavorazione stato) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.stato = stato;
	}

	public MateriaPrima(int id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.stato = StatoLavorazione.IN_INSERIMENTO;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	public StatoLavorazione getStato() {
		return stato;
	}

	public void setStato(StatoLavorazione stato) {
		this.stato = stato;
	}

	public String toString() {
		return "id=" + id + " : " + descrizione + " - " + stato.toString() + "";
	}

}
