package it.prova.model;

public class Cd {

	private Long id;
	private String titolo;
	private Autore autore;
	private String genere;
	private int numeroTracce;

	public Cd() {
	}

	public Cd(String titolo, Autore autore, String genere, int numeroTracce) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.numeroTracce = numeroTracce;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getNumeroTracce() {
		return numeroTracce;
	}

	public void setNumeroTracce(int numeroTracce) {
		this.numeroTracce = numeroTracce;
	}

	@Override
	public String toString() {
		return "Cd [titolo=" + titolo + ", genere=" + genere + ", numTracce=" + numeroTracce + ", autore =" + autore + "]";
	}
}
