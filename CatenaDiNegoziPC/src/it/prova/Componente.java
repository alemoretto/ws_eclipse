package it.prova;

public abstract class Componente {

	protected String nome;
	protected String matricola;
	protected String tipo;

	public Componente() {
	}

	public Componente(String tipo, String matricola) {
		this.tipo = tipo;
		this.matricola = matricola;
	}

	public Componente(String tipo, String matricola, String nome) {
		super();
		this.tipo = tipo;
		this.matricola = matricola;
		this.nome = nome;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Componente))
			return false;
		Componente c = (Componente) o;
		if (!c.getMatricola().equals(matricola))
			return false;
		return true;
	}

	public String toString() {
		return getTipo() + "  " + "\"" + getNome() + "\"" + "  " + getMatricola();
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
