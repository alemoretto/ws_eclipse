package it.prova;

public class Abitante {

	private String nome;
	private String cognome;
	private int eta;
	private Indirizzo indirizzo;

	public Abitante() {
	}

	public Abitante(String nome, Indirizzo indirizzo) {
		this.nome = nome;
		this.indirizzo = indirizzo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

}
