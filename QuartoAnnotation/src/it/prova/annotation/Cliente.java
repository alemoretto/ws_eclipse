package it.prova.annotation;

public abstract class Cliente {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	abstract void ordina();
}
