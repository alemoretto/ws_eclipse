package it.prova;

import java.util.List;

public abstract class Lavoratore {

	protected String nome;
	protected String cognome;
	protected int matricola;
	protected Negozio negozio;
	protected String qualifica;

	public Lavoratore() {
	}

	public Lavoratore(String nome, int matricola, String qualifica) {
		this.setNome(nome);
		this.setMatricola(matricola);
		this.setQualifica(qualifica);
	}

	public Lavoratore(String nome, int matricola, Negozio negozio, String qualifica) {
		super();
		this.setNome(nome);
		this.setMatricola(matricola);
		this.setNegozio(negozio);
		this.setQualifica(qualifica);
	}

	public abstract boolean handleItemAdd(Item item);

	public abstract boolean handleItemRemove(Item item);

	public static Lavoratore nomeToLavoratore(List<Lavoratore> lavoratori, String nomeLavoratore) {
		for (Lavoratore lavoratore : lavoratori) {
			if (lavoratore.getNome().equals(nomeLavoratore))
				return lavoratore;
		}
		return null;
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

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	
}
