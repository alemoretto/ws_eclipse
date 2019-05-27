package it.prova.model;

import java.util.ArrayList;

public class Autore {

	private Long idAutore;
	private String nome;
	private String cognome;
	private CasaDiscografica casaDiscografica;
	private List<CD> listaCD = new ArrayList<>();

	public Autore() {
	}

	public Autore(Long idAutore, String nome, String cognome, CasaDiscografica casaDiscografica, List<CD> listaCD) {
		super();
		this.idAutore = idAutore;
		this.nome = nome;
		this.cognome = cognome;
		this.casaDiscografica = casaDiscografica;
		this.listaCD = listaCD;
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

	public List<CD> getListaCD() {
		return listaCD;
	}

	public void setListaCD(List<CD> listaCD) {
		this.listaCD = listaCD;
	}

}
