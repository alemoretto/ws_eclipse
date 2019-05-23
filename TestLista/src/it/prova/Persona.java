package it.prova;

public class Persona {

	private String nome;
	private String cognome;
	
	public Persona() {}
	
	public Persona(String nome, String cognome){
		this.setNome(nome);
		this.setCognome(cognome);
	}

	public Persona(String nome){
		this.setNome(nome);
		this.setCognome(cognome);
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
	
}
