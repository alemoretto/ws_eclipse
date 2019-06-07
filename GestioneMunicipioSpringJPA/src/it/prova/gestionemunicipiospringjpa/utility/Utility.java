package it.prova.gestionemunicipiospringjpa.utility;

import javax.servlet.http.HttpServletRequest;

import it.prova.gestionemunicipiospringjpa.utility.Validazione;

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
}
