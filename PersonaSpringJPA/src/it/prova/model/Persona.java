package it.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String cf;
	private String indirizzo;
	private Integer eta;

	public Persona() {
	}
	
	public Persona(Long id, String nome, String cognome, String cf, String indirizzo, Integer eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.indirizzo = indirizzo;
		this.eta = eta;
	}

	public Persona(String nome, String cognome, String cf, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.indirizzo = indirizzo;
	}
	
	public Persona(String nome, String cognome, String cf, String indirizzo, Integer eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.indirizzo = indirizzo;
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}
	
}
