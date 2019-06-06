package it.prova.utility;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	public static Validazione checkInputPersona(HttpServletRequest request) {
		
		Validazione validazione = new Validazione(true, "");
		
		if (request.getParameter("nomeInput").equals("") 			|| 
			request.getParameter("cognomeInput").equals("")			|| 
			request.getParameter("cfInput").equals("")  			||
			request.getParameter("etaInput").equals("")  			||
			request.getParameter("indirizzoInput").equals("")) {
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Bisogna valorizzare tutti i campi");
			return validazione;
		} 
		if (integerParsed(request.getParameter("etaInput")) == null ||
			integerParsed(request.getParameter("etaInput")) <= 0	){
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Il valore inserito nel campo età non è valido");
			return validazione;
		}
		
		return validazione ;
	}
	
	public static Map<String,String> formToObject(HttpServletRequest request) {
		Map<String,String> personaString = new HashMap<String,String>();
		personaString.put("nomeInput", request.getParameter("nomeInput"));
		personaString.put("cognomeInput", request.getParameter("cognomeInput"));
		personaString.put("cfInput", request.getParameter("cfInput"));
		personaString.put("etaInput", request.getParameter("etaInput"));
		personaString.put("indirizzoInput", request.getParameter("indirizzoInput"));
		personaString.put("idInput", request.getParameter("idInput"));
		return personaString;
	}
	
	
	
}
