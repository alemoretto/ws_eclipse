package it.helloabitante.web.servlet;

import java.io.IOException;

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
		
		String paginaDestinazione = "results.jsp";
		boolean datiCorretti = true;
		String messaggioDiErrore = "";
		
		try {
			Integer.parseInt(request.getParameter("etaInput"));
		} catch (Exception e) {
			datiCorretti = false;
			messaggioDiErrore = "Attenzione! L'et� dev'essere un intero";
		}
		
		if (request.getParameter("nomeInput").equals("") 			|| 
			request.getParameter("cognomeInput").equals("")			|| 
			request.getParameter("codiceFiscaleInput").equals("")	|| 
			request.getParameter("etaInput").equals("")) {
			datiCorretti = false;
			messaggioDiErrore = "Attenzione! I campi Nome, Cognome, Codice Fiscale ed Et� sono obbligatori";
		}

		if (datiCorretti) {
			String nomeDaInserire = request.getParameter("nomeInput");
			String cognomeDaInserire = request.getParameter("cognomeInput");
			String codiceFiscaleDaInserire = request.getParameter("codiceFiscaleInput");
			String etaDaInserire = request.getParameter("etaInput");
			String mottoDiVitaDaInserire = request.getParameter("mottoDiVitaInput");

			Abitante abitanteNuovo = new Abitante(nomeDaInserire, cognomeDaInserire, codiceFiscaleDaInserire,
					Integer.parseInt(etaDaInserire), mottoDiVitaDaInserire);

			try {
				MyServiceFactory.getAbitanteServiceInstance().inserisciAbitante(abitanteNuovo);// );
				request.setAttribute("listAbitantiAttributeName",
				MyServiceFactory.getAbitanteServiceInstance().listaTuttiGliAbitanti());

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			request.setAttribute("messaggioDiErrore", messaggioDiErrore);
			paginaDestinazione = "nuovoAbitante.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	}

}
