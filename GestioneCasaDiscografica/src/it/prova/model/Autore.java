package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class Autore {

	private Long id;
	private String nome;
	private String cognome;
	private CasaDiscografica casaDiscografica;
	private List<Cd> listaCd = new ArrayList<>();

	public Autore() {
	}

	public Autore(Long id, String nome, String cognome, CasaDiscografica casaDiscografica, List<Cd> listaCD) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.casaDiscografica = casaDiscografica;
		this.listaCd = listaCD;
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

	public CasaDiscografica getCasaDiscografica() {
		return casaDiscografica;
	}

	public void setCasaDiscografica(CasaDiscografica casaDiscografica) {
		this.casaDiscografica = casaDiscografica;
	}

	public List<Cd> getListaCD() {
		return listaCd;
	}

	public void setListaCD(List<Cd> listaCd) {
		this.listaCd = listaCd;
	}

}
