package it.helloabitante.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paginaDestinazione = null;
		
		if (!checkInput(request).containsKey(false)) {
			String nomeDaInserire = request.getParameter("nomeInput");
			String cognomeDaInserire = request.getParameter("cognomeInput");
			String codiceFiscaleDaInserire = request.getParameter("codiceFiscaleInput");
			int etaDaInserire = Integer.parseInt(request.getParameter("etaInput"));
			String mottoDiVitaDaInserire = request.getParameter("mottoDiVitaInput");

			Abitante abitanteNuovo = new Abitante(nomeDaInserire, cognomeDaInserire, codiceFiscaleDaInserire,
					etaDaInserire, mottoDiVitaDaInserire);

			paginaDestinazione = "results.jsp";
			try {
				MyServiceFactory.getAbitanteServiceInstance().inserisciAbitante(abitanteNuovo);// );
				request.setAttribute("listAbitantiAttributeName",
				MyServiceFactory.getAbitanteServiceInstance().listaTuttiGliAbitanti());

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			request.setAttribute("messaggioDiErrore", checkInput(request).get(false));
			paginaDestinazione = "nuovoAbitante.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	}
	
	
	private Map<Boolean, String> checkInput(HttpServletRequest request) {
		Map<Boolean, String> checkResults = new HashMap<Boolean, String>();
		
		if (request.getParameter("nomeInput").equals("") 			|| 
				request.getParameter("cognomeInput").equals("")			|| 
				request.getParameter("codiceFiscaleInput").equals("")) {
				checkResults.put(false,"Attenzione! I campi Nome, Cognome, Codice Fiscale ed Età sono obbligatori");
				return checkResults;
		}
		
		try {
			int etaDaInserire = Integer.parseInt(request.getParameter("etaInput"));
			if(etaDaInserire < 0) {
				checkResults.put(false,"Attenzione! L'età non può essere minore di zero");
				return checkResults;
			}

		} catch (Exception e) {
			checkResults.put(false,"Attenzione! L'età dev'essere un intero");
			return checkResults;
		}
		
		return checkResults;	
	}
	
}


