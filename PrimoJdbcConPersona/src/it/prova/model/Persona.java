package it.prova.model;

public class Persona {
	private Long id;
	private String nome;
	private String cognome;
	private int eta;

	public Persona() {
	}

	public Persona(String nome, String cognome, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
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

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}

}
