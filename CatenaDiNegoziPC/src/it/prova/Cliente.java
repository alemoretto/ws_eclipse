package it.prova;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

	private String nome;
	private String cognome;
	private String telefono;
	private List<PC> acquisti = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(String nome, List<PC> acquisti) {
		super();
		this.nome = nome;
		this.acquisti = acquisti;
	}

	public Cliente(String nome, String cognome, String telefono, List<PC> acquisti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.acquisti = acquisti;
	}

	public String toString() {
		return nome;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<PC> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(List<PC> acquisti) {
		this.acquisti = acquisti;
	}

}
