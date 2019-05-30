package it.negozioarticolijpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Articolo implements Serializable {

	private static final long serialVersionUID = -3253059373073442670L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "matricola")
	private String matricola;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "negozio_id", nullable = false)
	private Negozio negozio;

	public Articolo() {
	}

	public Articolo(String nome, String matricola, Negozio negozio) {
		super();
		this.nome = nome;
		this.matricola = matricola;
		this.negozio = negozio;
	}

	public Articolo(Long id, String nome, String matricola, Negozio negozio) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricola = matricola;
		this.negozio = negozio;
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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	@Override
	public String toString() {
		return "Articolo [nome=" + nome + ", matricola=" + matricola + ", negozio=" + negozio + "]";
	}

}
