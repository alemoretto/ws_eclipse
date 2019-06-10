package it.prova.gestionecartelleesattorialispringjpa.model.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

public class ContribuenteDTO {
	private String id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzo;

	public ContribuenteDTO() {
	}

	public ContribuenteDTO(String id, String nome, String cognome, String codiceFiscale, String indirizzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}

	public ContribuenteDTO(String nome, String cognome, String codiceFiscale, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}

	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.nome)) {
			validazione.put("nomeInput", "Attenzione! Il campo Nome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.cognome)) {
			validazione.put("cognomeInput", "Attenzione! Il campo Cognome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.codiceFiscale)) {
			validazione.put("codiceFiscaleInput", "Attenzione! Il campo Codice Fiscale è obbligatorio");
		} else if (this.codiceFiscale.length() != 16) {
			validazione.put("codiceFiscaleInput", "Attenzione! Il campo Codice Fiscale richiede 16 caratteri");
		}

		if (StringUtils.isEmpty(this.indirizzo)) {
			validazione.put("indirizzoInput", "Attenzione! Il campo Indirizzo è obbligatorio");
		}

		return validazione;
	}

	public static Contribuente buildContribuenteInstance(ContribuenteDTO contribuenteDTO) {
		return new Contribuente(Long.parseLong(contribuenteDTO.getId()), contribuenteDTO.getNome(),
				contribuenteDTO.getCognome(), contribuenteDTO.getCodiceFiscale(), contribuenteDTO.getIndirizzo());
	}

	public static ContribuenteDTO buildContribuenteDTOInstance(Contribuente contribuente) {
		return new ContribuenteDTO(contribuente.getId().toString(), contribuente.getNome(), contribuente.getCognome(),
				contribuente.getCodiceFiscale(), contribuente.getIndirizzo());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String toString() {
		return this.nome + " " + this.cognome;
	}
}
