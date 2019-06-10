package it.prova.gestionecartelleesattorialispringjpa.model.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;

public class CartellaEsattorialeDTO {

	private Long id;
	private String denominazione;
	private String descrizione;
	private String importo;
	private String contribuente;
	private String contribuenteDettaglio;

	public CartellaEsattorialeDTO(Long id, String denominazione, String descrizione, String importo,
			String contribuente) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.contribuente = contribuente;
	}

	public CartellaEsattorialeDTO(String denominazione, String descrizione, String importo, String contribuente) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.contribuente = contribuente;
	}

	public CartellaEsattorialeDTO(String denominazione, String descrizione, String importo) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
	}

	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.denominazione)) {
			validazione.put("denominazioneInput", "Attenzione! Il campo Denominazione è obbligatorio");
		}

		if (StringUtils.isEmpty(this.descrizione)) {
			validazione.put("descrizioneInput", "Attenzione! Il campo Descrizione è obbligatorio");
		}

		if (StringUtils.isEmpty(this.importo)) {
			validazione.put("importoInput", "Attenzione! Il campo Importo è obbligatorio");
		} else {
			try {
				Integer.parseInt(this.importo);
			} catch (Exception e) {
				validazione.put("importoInput", "Attenzione! Il campo Importo dev'essere maggiore di zero");
			}
		}

		if (Long.parseLong(this.contribuente) == -1) {
			validazione.put("contribuenteInput", "Attenzione! Non hai selezionato nessun Contribuente");
		}

		return validazione;
	}

	public static CartellaEsattoriale buildCartellaEsattorialeInstance(CartellaEsattorialeDTO cartellaEsattorialeDTO) {
		CartellaEsattoriale cartellaEsattoriale = new CartellaEsattoriale();
		cartellaEsattoriale.setId(cartellaEsattorialeDTO.getId());
		cartellaEsattoriale.setDenominazione(cartellaEsattorialeDTO.getDenominazione());
		cartellaEsattoriale.setDescrizione(cartellaEsattorialeDTO.getDescrizione());
		try {
			cartellaEsattoriale.setImporto(Integer.parseInt(cartellaEsattorialeDTO.getImporto()));
		} catch (Exception e) {
		}

		return cartellaEsattoriale;
	}

	public static CartellaEsattorialeDTO buildCartellaEsattorialeDTOInstance(CartellaEsattoriale cartellaEsattoriale) {
		CartellaEsattorialeDTO cartellaEsattorialeDTO = new CartellaEsattorialeDTO(cartellaEsattoriale.getId(),
				cartellaEsattoriale.getDenominazione(), cartellaEsattoriale.getDescrizione(),
				Integer.toString(cartellaEsattoriale.getImporto()),
				cartellaEsattoriale.getContribuente().getId().toString());
		try {
			cartellaEsattorialeDTO.setContribuenteDettaglio(cartellaEsattoriale.getContribuente().toString() + " - "
					+ cartellaEsattoriale.getContribuente().getCodiceFiscale());
		} catch (Exception e) {
		}

		return cartellaEsattorialeDTO;
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

	public String getContribuente() {
		return contribuente;
	}

	public void setContribuente(String contribuente) {
		this.contribuente = contribuente;
	}

	public String getContribuenteDettaglio() {
		return contribuenteDettaglio;
	}

	public void setContribuenteDettaglio(String contribuenteDettaglio) {
		this.contribuenteDettaglio = contribuenteDettaglio;
	}

}
