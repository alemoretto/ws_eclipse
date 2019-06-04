package it.prova.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concessionario")
public class Concessionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String denominazione;
	private String citta;
	private String partitaIva;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "concessionario", orphanRemoval = true)
	private List<Motociclo> motocicli = new ArrayList<>();
	
	public Concessionario() {
		
	}

	public Concessionario(Long id, String denominazione, String citta, String partitaIva, List<Motociclo> motocicli) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.citta = citta;
		this.partitaIva = partitaIva;
		this.motocicli = motocicli;
	}

	public Concessionario(String denominazione, String citta, String partitaIva) {
		super();
		this.denominazione = denominazione;
		this.citta = citta;
		this.partitaIva = partitaIva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Motociclo> getMotocicli() {
		return motocicli;
	}

	public void setMotocicli(List<Motociclo> motocicli) {
		this.motocicli = motocicli;
	}
	
	public String toString() {
		return denominazione + ", " + citta + " (" + partitaIva + ")"; 
	}

	public String toStringEager() {
		return toString() + " : " + motocicli; 
	}
}
