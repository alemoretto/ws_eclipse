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
import it.prova.gestionecartelleesattorialispringjpa.model.dto.ContribuenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;

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

//		if (Utility.inputContribuente(request).isNotValid()) {
//			request.setAttribute("messaggioDiErrore", Utility.inputContribuente(request).getMessaggio());
//
//			RequestDispatcher rd = request.getRequestDispatcher("/contribuente/insert.jsp");
//			rd.forward(request, response);
//			
//			return;
//		} 

//			String nomeInput = request.getParameter("nomeInput");
//			String cognomeInput = request.getParameter("cognomeInput");
//			String codiceFiscaleInput = request.getParameter("codiceFiscaleInput");
//			String indirizzoInput = request.getParameter("indirizzoInput");
//
//			Contribuente contribuenteDaInserire = new Contribuente(nomeInput, cognomeInput, codiceFiscaleInput,
//					indirizzoInput);
		ContribuenteDTO contribuenteDTO = new ContribuenteDTO(request.getParameter("nomeInput"),
				request.getParameter("cognomeInput"), request.getParameter("codiceFiscaleInput"),
				request.getParameter("indirizzoInput"));
		if (!contribuenteDTO.validate().isEmpty()) {
			request.setAttribute("messaggiDiErrore", contribuenteDTO.validate());
			RequestDispatcher rd = request.getRequestDispatcher("/contribuente/insert.jsp");
			rd.forward(request, response);

			return;
		}
		Contribuente contribuenteDaInserire = ContribuenteDTO.buildContribuenteInstance(contribuenteDTO);
		contribuenteService.inserisci(contribuenteDaInserire);

		response.sendRedirect("SendRedirectContribuenteServlet");
	}

}
