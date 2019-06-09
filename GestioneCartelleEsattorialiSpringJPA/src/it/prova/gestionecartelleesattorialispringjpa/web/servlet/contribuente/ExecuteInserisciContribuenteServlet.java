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

@WebServlet("/ExecuteInserisciContribuenteServlet")
public class ExecuteInserisciContribuenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInserisciContribuenteServlet() {
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
			String nomeInput = request.getParameter("nomeInput");
			String cognomeInput = request.getParameter("cognomeInput");
			String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");
			String indirizzoInput = request.getParameter("indirizzoInput");

			Contribuente contribuenteDaInserire = new Contribuente(nomeInput, cognomeInput, codiceFiscaleInput,
					indirizzoInput);
			contribuenteService.inserisci(contribuenteDaInserire);

//			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAll());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/SendRedirectContribuenteServlet");
		rd.forward(request, response);
	}

}
