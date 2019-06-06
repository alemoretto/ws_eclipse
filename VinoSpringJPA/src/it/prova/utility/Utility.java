package it.prova.utility;

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
	
	public static Validazione checkInputVino(HttpServletRequest request) {
		
		Validazione validazione = new Validazione(true, "");
		
		if (request.getParameter("nomeInput").equals("") 			|| 
			request.getParameter("uvaInput").equals("")			|| 
			request.getParameter("cantinaInput").equals("")  			||
			request.getParameter("annataInput").equals("")  			||
			request.getParameter("localitaInput").equals("")) {
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Bisogna valorizzare tutti i campi");
			return validazione;
		} 
		if (integerParsed(request.getParameter("annataInput")) == null ||
			integerParsed(request.getParameter("annataInput")) <= 0	){
			validazione.setEsito(false);
			validazione.setMessaggio("Attenzione! Il valore inserito nel campo ANNATA non è valido");
			return validazione;
		}
		
		return validazione ;
	}
	
//	public static Map<String,String> formToObject(HttpServletRequest request) {
//		Map<String,String> vinoString = new HashMap<String,String>();
//		vinoString.put("nomeInput", request.getParameter("nomeInput"));
//		vinoString.put("uvaInput", request.getParameter("uvaInput"));
//		vinoString.put("cantinaInput", request.getParameter("cantinaInput"));
//		vinoString.put("annataInput", request.getParameter("annataInput"));
//		vinoString.put("localitaInput", request.getParameter("localitaInput"));
//		vinoString.put("idInput", request.getParameter("idInput"));
//		return vinoString;
//	}
	
	
	
}
