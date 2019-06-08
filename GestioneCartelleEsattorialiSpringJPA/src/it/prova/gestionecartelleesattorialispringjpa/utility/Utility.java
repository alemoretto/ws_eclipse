package it.prova.gestionecartelleesattorialispringjpa.utility;

import javax.servlet.http.HttpServletRequest;

import it.prova.gestionecartelleesattorialispringjpa.utility.Validazione;

public class Utility {
	public static Integer integerParsed(String string) {
		Integer parsed = null;
		try {
			parsed = Integer.parseInt(string);
		} catch (Exception e) {
		}

		return parsed;
	}

	public static Long longParsed(String string) {
		Long parsed = null;
		try {
			parsed = Long.parseLong(string);
		} catch (Exception e) {
		}

		return parsed;
	}

	public static Validazione checkInputMunicipio(HttpServletRequest request) {

		Validazione validazione = new Validazione(true, "");

		if (request.getParameter("descrizioneInput").equals("") || 
			request.getParameter("codiceInput").equals("")  || 
			request.getParameter("ubicazioneInput").equals("") ) {
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Bisogna valorizzare tutti i campi");
			return validazione;
		}

		return validazione;
	}
	
	public static Validazione checkInputAbitante(HttpServletRequest request) {

		Validazione validazione = new Validazione(true, "");

		if (request.getParameter("nomeInput").equals("") || 
			request.getParameter("cognomeInput").equals("")  || 
			request.getParameter("residenzaInput").equals("") ||
			request.getParameter("etaInput").equals("")) {
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Bisogna valorizzare tutti i campi");
			return validazione;
		}
		
		if (integerParsed(request.getParameter("etaInput")) == null
				|| integerParsed(request.getParameter("etaInput")) <= 0) {
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Il valore inserito nel campo età non è valido");
			return validazione;
		}
		
		if (longParsed(request.getParameter("municipioInput")) == -1L) {
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Non hai selezionato nessun Municipio");
			return validazione;
		}
		return validazione;
	}
}
