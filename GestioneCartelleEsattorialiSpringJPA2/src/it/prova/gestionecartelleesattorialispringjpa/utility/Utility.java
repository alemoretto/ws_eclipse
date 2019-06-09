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

	public static Validazione inputContribuente(HttpServletRequest request) {

		Validazione validazione = new Validazione(true, "");

		if (request.getParameter("nomeInput").equals("") || 
			request.getParameter("cognomeInput").equals("")  ||
			request.getParameter("codiceFiscaleInput").equals("") || 
			request.getParameter("indirizzoInput").equals("")  ) {

			return new Validazione(false,"Attenzione! Bisogna valorizzare tutti i campi");
		} 

		if (request.getParameter("codiceFiscaleInput").length() != 16 ) {
			return new Validazione(false,"Attenzione! Il campo Codice Fiscale richiede 16 caratteri");
		}
		
		return validazione;
	}
	
	public static Validazione inputAbitante(HttpServletRequest request) {

		Validazione validazione = new Validazione(true, "");

		if (request.getParameter("nomeInput").equals("") || 
			request.getParameter("cognomeInput").equals("")  || 
			request.getParameter("residenzaInput").equals("") ||
			request.getParameter("etaInput").equals("")) {
			return validazione;
		}
		
		if (integerParsed(request.getParameter("etaInput")) == null
				|| integerParsed(request.getParameter("etaInput")) <= 0) {
			return validazione;
		}
		
		if (longParsed(request.getParameter("municipioInput")) == -1L) {
			return validazione;
		}
		return validazione;
	}
}
