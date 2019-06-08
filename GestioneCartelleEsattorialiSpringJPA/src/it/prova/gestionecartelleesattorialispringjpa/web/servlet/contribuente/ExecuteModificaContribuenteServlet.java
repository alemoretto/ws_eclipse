package it.prova.gestionecartelleesattorialispringjpa.web.servlet.contribuente;

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

import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;
import it.prova.gestionecartelleesattorialispringjpa.utility.Utility;

@WebServlet("/ExecuteModificaContribuenteServlet")
public class ExecuteModificaContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaContribuenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		String paginaDestinazione = "/contribuente/result.jsp";

		if (!Utility.checkInputContribuente(request).getEsito()) {
			request.setAttribute("messaggioDiErrore", Utility.checkInputContribuente(request).getMessaggio());

			paginaDestinazione = "/contribuente/insert.jsp";
		} else {
			Long idInput = Long.parseLong(request.getParameter("idInput"));
			String nomeInput = request.getParameter("nomeInput");
			String cognomeInput = request.getParameter("cognomeInput");
			String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");
			String indirizzoInput = request.getParameter("indirizzoInput");

			Contribuente contribuenteDaAggiornare = new Contribuente(idInput, nomeInput, cognomeInput,
					codiceFiscaleInput, indirizzoInput);
			contribuenteService.aggiorna(contribuenteDaAggiornare);

			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAll());
		}

		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	}

}
