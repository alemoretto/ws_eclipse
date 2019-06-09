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
	
	public static Validazione inputCartellaEsattoriale(HttpServletRequest request) {

		Validazione validazione = new Validazione(true, "");

		if (request.getParameter("denominazioneInput").equals("") || 
			request.getParameter("descrizioneInput").equals("")  || 
			request.getParameter("importoInput").equals("") ) {
			return new Validazione(false,"Attenzione! Bisogna valorizzare tutti i campi");
		}
		
		if (integerParsed(request.getParameter("importoInput")) == null
				|| integerParsed(request.getParameter("importoInput")) < 0) {
			return new Validazione(false,"Attenzione! L'importo dev'essere un numero positivo");
		}
		
		if (longParsed(request.getParameter("contribuenteInput")) == -1L) {
			return new Validazione(false,"Attenzione! Bisogna selezionare un contribuente");
		}
		
		return validazione;
	}
}
