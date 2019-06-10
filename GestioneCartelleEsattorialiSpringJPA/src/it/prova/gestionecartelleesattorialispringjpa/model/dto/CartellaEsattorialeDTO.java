package it.prova.gestionecartelleesattorialispringjpa.model.dto;

import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

public class CartellaEsattorialeDTO {

	private Long id;
	private String denominazione;
	private String descrizione;
	private String importo;
//	private String contribuente;
	
	public CartellaEsattorialeDTO(Long id, String denominazione, String descrizione, String importo) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
	}

	public CartellaEsattorialeDTO(String denominazione, String descrizione, String importo) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
	}

	public static CartellaEsattoriale buildCartellaEsattorialeInstance(CartellaEsattorialeDTO cartellaEsattorialeDTO) {
		return new Contribuente(Long.parseLong(contribuenteDTO.getId()), contribuenteDTO.getNome(),
				contribuenteDTO.getCognome(), contribuenteDTO.getCodiceFiscale(), contribuenteDTO.getIndirizzo());
	}

	public static ContribuenteDTO buildContribuenteDTOInstance(Contribuente contribuente) {
		return new ContribuenteDTO(contribuente.getId().toString(), contribuente.getNome(), contribuente.getCognome(),
				contribuente.getCodiceFiscale(), contribuente.getIndirizzo());
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

	public String getImporto() {
		return importo;
	}

	public void setImporto(String importo) {
		this.importo = importo;
	}
	
	
	
}
