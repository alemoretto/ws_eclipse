package it.prova.model;

public class Articolo {

	private Long id;
	private String nome;
	private String matricola;
	private Negozio negozio;

	public Articolo() {
	}

	public Articolo(String nome, String matricola, Negozio negozio) {
		super();
		this.nome = nome;
		this.matricola = matricola;
		this.negozio = negozio;
	}

	public Articolo(Long id, String nome, String matricola, Negozio negozio) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricola = matricola;
		this.negozio = negozio;
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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	@Override
	public String toString() {
		return "Articolo [nome=" + nome + ", matricola=" + matricola + ", negozio=" + negozio + "]";
	}

}
