package it.prova.model;

public class Cd {

	private Long idCd;
	private String titolo;
	private Autore autore;
	private String genere;
	private int numeroTracce;

	public Cd() {
	}

	public Cd(Long idCd, String titolo, Autore autore, String genere, int numeroTracce) {
		super();
		this.idCd = idCd;
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.numeroTracce = numeroTracce;
	}

	public Long getIdCd() {
		return idCd;
	}

	public void setIdCd(Long idCd) {
		this.idCd = idCd;
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

}
