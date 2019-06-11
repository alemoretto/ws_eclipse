package it.prova.gestionecartelleesattorialispringjpa.web.servlet.utente;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionecartelleesattorialispringjpa.model.Ruolo;
import it.prova.gestionecartelleesattorialispringjpa.model.Utente;
import it.prova.gestionecartelleesattorialispringjpa.model.dto.UtenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.service.ruolo.RuoloService;
import it.prova.gestionecartelleesattorialispringjpa.service.utente.UtenteService;

@WebServlet("/admin/ExecuteInserisciUtenteServlet")
public class ExecuteInserisciUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInserisciUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtenteDTO utenteDTO = new UtenteDTO(request.getParameter("nomeInput"), request.getParameter("cognomeInput"),
				request.getParameter("usernameInput"), request.getParameter("passwordInput"));

		if (!utenteDTO.validate().isEmpty()) {
			request.setAttribute("utenteDTOAttribute", utenteDTO);
			request.setAttribute("listRuoliAttribute", ruoloService.listAll());
			request.setAttribute("messaggiDiErrore", utenteDTO.validate());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/insert.jsp");
			rd.forward(request, response);

			return;
		}

		Utente utenteDaInserire = UtenteDTO.buildUtenteInstance(utenteDTO);
		String[] ruoli = request.getParameterValues("ruoloItem");
		if(ruoli != null && ruoli.length> 0) {
		Set<Ruolo> ruoliSet = new HashSet<>();
		for (String ruoloId : ruoli) {
			ruoliSet.add(new Ruolo(Long.parseLong(ruoloId)));
		}
		utenteDaInserire.setRuoli(ruoliSet);
		}
		utenteDaInserire.setDataRegistrazione(new Date());
		utenteService.inserisci(utenteDaInserire);

		response.sendRedirect("SendRedirectUtenteServlet");

	}

}
