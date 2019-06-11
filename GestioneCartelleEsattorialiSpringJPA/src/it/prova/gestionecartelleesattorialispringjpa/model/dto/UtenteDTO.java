package it.prova.gestionecartelleesattorialispringjpa.model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import it.prova.gestionecartelleesattorialispringjpa.model.Ruolo;
import it.prova.gestionecartelleesattorialispringjpa.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private List<String> iDruoli = new ArrayList<>();
	private Map<String, String> fieldsValues = new LinkedHashMap<String, String>();

	public UtenteDTO(Long id, String nome, String cognome, String username, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		fillFieldsValues();
	}
	
	public UtenteDTO(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		fillFieldsValues();
	}

	private void fillFieldsValues() {
		fieldsValues.put("Nome", this.nome);
		fieldsValues.put("Cognome", this.cognome);
		fieldsValues.put("Username", this.username);
		fieldsValues.put("Password", this.password);
		return;
	}
	
	public Map<String, String> fieldsNames() {
		Map<String, String> listaCampi = new LinkedHashMap<String, String>();
		listaCampi.put("Nome", "nomeInput");
		listaCampi.put("Cognome", "cognomeInput");
		listaCampi.put("Username", "usernameInput");
		listaCampi.put("Password", "passwordInput");
		return listaCampi;
	}

	public static Utente buildUtenteInstance(UtenteDTO utenteDTO) {
		Utente utente = new Utente(utenteDTO.getNome(), utenteDTO.getCognome(), utenteDTO.getUsername(),
				utenteDTO.getPassword());
		try {
			utente.setId(utenteDTO.getId());
		} catch (Exception e) {
		}
		return utente;
	}

	public static UtenteDTO buildUtenteDTOInstance(Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO(utente.getNome(), utente.getCognome(), utente.getUsername(),
				utente.getPassword());

		try {
			utenteDTO.setId(utente.getId());
		} catch (Exception e) {
		}
		
		if (utente.getRuoli().size() > 0) {
			List<String> iDruoli = new ArrayList<>();
			for (Ruolo ruolo : utente.getRuoli()) {
				iDruoli.add(Long.toString(ruolo.getId()));
			}
			utenteDTO.setiDruoli(iDruoli);
		}

		return utenteDTO;
	}

	public UtenteDTO() {
	}

	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.nome)) {
			validazione.put("nomeInput", "Attenzione! Il campo Nome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.cognome)) {
			validazione.put("cognomeInput", "Attenzione! Il campo Cognome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.username)) {
			validazione.put("usernameInput", "Attenzione! Il campo Username è obbligatorio");
		}

		if (StringUtils.isEmpty(this.password)) {
			validazione.put("passwordInput", "Attenzione! Il campo Password è obbligatorio");
		}

//		fieldsValues.put("Nome", this.nome);
//		fieldsValues.put("Cognome", this.cognome);
//		fieldsValues.put("Username", this.username);
//		fieldsValues.put("Password", this.password);
		fillFieldsValues();
		return validazione;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getFieldsValues() {
		return fieldsValues;
	}

	public void setFieldsValues(Map<String, String> fieldsValues) {
		this.fieldsValues = fieldsValues;
	}

	public List<String> getiDruoli() {
		return iDruoli;
	}

	public void setiDruoli(List<String> iDruoli) {
		this.iDruoli = iDruoli;
	}

}
