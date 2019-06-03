package it.prova.model;

public class Studente {

	private String nome;
	private String cognome;

	private Esame esame;

	public Studente() {
	}

	public Studente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public Studente(String nome, String cognome, Esame esame) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.esame = esame;
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

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	@Override
	public String toString() {
		return nome + " " + cognome;
	}

}
