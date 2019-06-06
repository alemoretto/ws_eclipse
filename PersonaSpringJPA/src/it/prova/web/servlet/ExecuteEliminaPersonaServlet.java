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

import it.prova.service.PersonaService;

@WebServlet("/ExecuteEliminaPersonaServlet")
public class ExecuteEliminaPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaService personaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteEliminaPersonaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idPersonaDaPagina = request.getParameter("idPersona");

			personaService.rimuoviPersona(personaService.caricaSingolaPersona(Long.parseLong(idPersonaDaPagina)));

			request.setAttribute("listaPersoneAttributeName", personaService.listaCompleta());
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
