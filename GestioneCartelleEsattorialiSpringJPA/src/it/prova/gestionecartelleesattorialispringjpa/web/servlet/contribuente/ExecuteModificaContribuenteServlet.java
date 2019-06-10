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

import it.prova.gestionecartelleesattorialispringjpa.model.dto.ContribuenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;

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

		/*
		 * Questa versione commentata è la prima implementata, senza DTO e senza JSTL
		 * ...........................................................................
		 * 
		 * if (Utility.inputContribuente(request).isNotValid()) {
		 * request.setAttribute("messaggioDiErrore",
		 * Utility.inputContribuente(request).getMessaggio());
		 * 
		 * Long idInput = Long.parseLong(request.getParameter("idInput"));
		 * request.setAttribute("contribuenteDaModificareAttributeName",
		 * contribuenteService.carica(idInput));
		 * 
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/contribuente/modifica.jsp");
		 * rd.forward(request, response);
		 * 
		 * return; }
		 * 
		 * Long idInput = Long.parseLong(request.getParameter("idInput")); String
		 * nomeInput = request.getParameter("nomeInput"); String cognomeInput =
		 * request.getParameter("cognomeInput"); String codiceFiscaleInput =
		 * request.getParameter("codiceFiscaleInput"); String indirizzoInput =
		 * request.getParameter("indirizzoInput");
		 * 
		 * Contribuente contribuenteDaAggiornare = new Contribuente(idInput, nomeInput,
		 * cognomeInput, codiceFiscaleInput, indirizzoInput);
		 */

		ContribuenteDTO contribuenteDTO = new ContribuenteDTO(Long.parseLong(request.getParameter("idInput")),
				request.getParameter("nomeInput"), request.getParameter("cognomeInput"),
				request.getParameter("codiceFiscaleInput"), request.getParameter("indirizzoInput"));

		if (!contribuenteDTO.validate().isEmpty()) {
			request.setAttribute("contribuenteDTOAttribute", contribuenteDTO);
			request.setAttribute("messaggiDiErrore", contribuenteDTO.validate());
			RequestDispatcher rd = request.getRequestDispatcher("/contribuente/modifica.jsp");
			rd.forward(request, response);

			return;
		}

		contribuenteService.aggiorna(ContribuenteDTO.buildContribuenteInstance(contribuenteDTO));

		response.sendRedirect("SendRedirectContribuenteServlet");

	}

}
