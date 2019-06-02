package it.carrello.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String descrizione;
//	@ManyToMany(mappedBy = "categorie")
	@ManyToMany
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"))
	private Set<Articolo> articoli = new HashSet<Articolo>();
	
	public Categoria(Long id, String descrizione, Set<Articolo> articoli) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.articoli = articoli;
	}

	public Categoria(String descrizione) {
		super();
		this.descrizione = descrizione;
	}
	
	public Categoria() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	
	public void addArticolo(Articolo articolo) {
		articoli.add(articolo);
		articolo.getCategorie().add(this);
	}
	
	public String toString() {
		String stringaArticoli = "";
		for (Articolo articolo : articoli) {
			stringaArticoli += articolo.getDescrizione() + " ";
		}
		
		return "DESCRIZIONE [id=" + id + ", descrizione=" + descrizione + ": " + stringaArticoli + "]"; 
	}

}
