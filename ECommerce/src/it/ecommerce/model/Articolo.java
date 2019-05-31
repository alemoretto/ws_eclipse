package it.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import it.ecommerce.model.Ordine;

@Entity
@Table(name = "articolo")
public class Articolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String descrizione;
	private Integer prezzoSingolo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	private Ordine ordine;
	@ManyToMany
	@JoinTable(name = "ordine_categoria", joinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<>(0);
	
	public Articolo(Long id, String descrizione, Integer prezzoSingolo, Ordine ordine, Set<Categoria> categorie) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.prezzoSingolo = prezzoSingolo;
		this.ordine = ordine;
		this.categorie = categorie;
	}

	public Articolo() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getPrezzoSingolo() {
		return prezzoSingolo;
	}

	public void setPrezzoSingolo(Integer prezzoSingolo) {
		this.prezzoSingolo = prezzoSingolo;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	
	
}
