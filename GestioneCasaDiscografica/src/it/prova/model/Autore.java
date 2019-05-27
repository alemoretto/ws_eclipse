package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class Autore {

	private Long idAutore;
	private String nome;
	private String cognome;
	private CasaDiscografica casaDiscografica;
	private List<Cd> listaCd = new ArrayList<>();

	public Autore() {
	}

	public Autore(Long idAutore, String nome, String cognome, CasaDiscografica casaDiscografica, List<Cd> listaCD) {
		super();
		this.idAutore = idAutore;
		this.nome = nome;
		this.cognome = cognome;
		this.casaDiscografica = casaDiscografica;
		this.listaCd = listaCD;
	}

	public Long getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
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
