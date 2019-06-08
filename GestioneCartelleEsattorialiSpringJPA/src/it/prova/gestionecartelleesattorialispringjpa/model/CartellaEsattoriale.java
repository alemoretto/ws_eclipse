package it.prova.gestionecartelleesattorialispringjpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartellaEsattoriale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String denominazione;
	private String descrizione;
	private int importo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contribuente_id", nullable = false)
	private CartellaEsattoriale cartellaEsattoriale;

	public CartellaEsattoriale() {
	}

	public CartellaEsattoriale(Long id, String denominazione, String descrizione, int importo,
			CartellaEsattoriale cartellaEsattoriale) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.cartellaEsattoriale = cartellaEsattoriale;
	}

	public CartellaEsattoriale(String denominazione, String descrizione, int importo,
			CartellaEsattoriale cartellaEsattoriale) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.cartellaEsattoriale = cartellaEsattoriale;
	}

	public CartellaEsattoriale(String denominazione, String descrizione, int importo) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public CartellaEsattoriale getCartellaEsattoriale() {
		return cartellaEsattoriale;
	}

	public void setCartellaEsattoriale(CartellaEsattoriale cartellaEsattoriale) {
		this.cartellaEsattoriale = cartellaEsattoriale;
	}

}
