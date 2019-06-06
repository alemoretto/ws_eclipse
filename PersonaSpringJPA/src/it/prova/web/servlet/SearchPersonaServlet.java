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

@WebServlet("/SearchPersonaServlet")
public class SearchPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonaService personaService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SearchPersonaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String cfInput = request.getParameter("cfInput");
		String indirizzoInput = request.getParameter("indirizzoInput");

		Persona example = new Persona(nomeInput, cognomeInput, cfInput, indirizzoInput);

		request.setAttribute("listaPersoneAttributeName", personaService.cercaPersonaByExample(example));

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
