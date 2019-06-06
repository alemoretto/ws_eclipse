package it.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vino {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String uva; // cognome
	private String cantina; // cf
	private String localita; // indirizzo
	private Integer annata; // annata

	public Vino() {
	}

	public Vino(Long id, String nome, String uva, String cantina, String localita, Integer annata) {
		super();
		this.id = id;
		this.nome = nome;
		this.uva = uva;
		this.cantina = cantina;
		this.localita = localita;
		this.annata = annata;
	}

	public Vino(String nome, String uva, String cantina, String localita, Integer annata) {
		super();
		this.nome = nome;
		this.uva = uva;
		this.cantina = cantina;
		this.localita = localita;
		this.annata = annata;
	}

	public Vino(String nome, String uva, String cantina, String localita) {
		super();
		this.nome = nome;
		this.uva = uva;
		this.cantina = cantina;
		this.localita = localita;
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

	public String getUva() {
		return uva;
	}

	public void setUva(String uva) {
		this.uva = uva;
	}

	public String getCantina() {
		return cantina;
	}

	public void setCantina(String cantina) {
		this.cantina = cantina;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public Integer getAnnata() {
		return annata;
	}

	public void setAnnata(Integer annata) {
		this.annata = annata;
	}
	
	
}
