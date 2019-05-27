package it.miopackage.jdbc.model;

public class Abitante {

	private Long id;
	private String nome;
	private String cognome;
	private int eta;
	private Indirizzo indirizzo;

	public Abitante() {
	}

	public Abitante(String nome, String cognome, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public Abitante(String nome, String cognome, int eta, Indirizzo indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.indirizzo = indirizzo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Abitante [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", indirizzo="
				+ indirizzo + "]";
	}

}
