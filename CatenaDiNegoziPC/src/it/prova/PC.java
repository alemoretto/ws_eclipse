package it.prova;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PC {

	private String nome;
	private String matricola;
	private List<Componente> componenti = new ArrayList<>();

	public PC() {
	}

	public PC(String nome, String matricola, Componente... componenti) {
		super();
		this.nome = nome;
		this.matricola = matricola;
		this.componenti.addAll(Arrays.asList(componenti));
	}

	public boolean haComponente(Componente componente) {
		for (Componente comp : componenti) {
			if (comp.equals(componente))
				return true;
		}
		return false;
	}

	public String toString() {
		return getNome() + " " + getMatricola();
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof PC))
			return false;
		PC pc = (PC) o;
		if (!pc.getMatricola().equals(matricola))
			return false;
		return true;
	}

	public String mostraDettagli() {
		String result = nome + " " + matricola + "\n	(";
		for (Componente componente : componenti) {
			result += componente.toString() + ", ";
		}
		result = result.substring(0, result.length() - 2);
		result += ")";
		return result;
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

	public List<Componente> getComponenti() {
		return componenti;
	}

	public void setComponenti(List<Componente> componenti) {
		this.componenti = componenti;
	}

}
