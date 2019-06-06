package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.model.Persona;
import it.prova.service.PersonaService;
import it.prova.utility.Utility;

@WebServlet("/ExecuteInsertPersonaServlet")
public class ExecuteInsertPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private PersonaService personaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    public ExecuteInsertPersonaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestinazione = "result.jsp";

		if (!Utility.checkInputPersona(request).getEsito()) {
			request.setAttribute("messaggioDiErrore", Utility.checkInputPersona(request).getMessaggio());
			
			paginaDestinazione = "nuovaPersona.jsp";
		} else {
			String nomeInput = request.getParameter("nomeInput");
			String cognomeInput = request.getParameter("cognomeInput");
			String cfInput = request.getParameter("cfInput");
			Integer etaInput = Integer.parseInt(request.getParameter("etaInput"));
			String indirizzoInput = request.getParameter("indirizzoInput");
			
			Persona personaDaInserire = new Persona(nomeInput, cognomeInput, cfInput, indirizzoInput, etaInput);
			personaService.inserisciPersona(personaDaInserire);

			request.setAttribute("listaPersoneAttributeName", personaService.listaCompleta());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	}

}
