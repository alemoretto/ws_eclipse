package it.prova.gestionecartelleesattorialispringjpa.web.servlet.utente;

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

import it.prova.gestionecartelleesattorialispringjpa.model.Utente;
import it.prova.gestionecartelleesattorialispringjpa.model.dto.UtenteDTO;
import it.prova.gestionecartelleesattorialispringjpa.service.utente.UtenteService;

@WebServlet("/admin/VisualizzaDettaglioUtenteServlet")
public class VisualizzaDettaglioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public VisualizzaDettaglioUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idUtenteDaPagina = Long.parseLong(request.getParameter("idUtente"));
		Utente utenteCaricato = utenteService.caricaEager(idUtenteDaPagina);
		request.setAttribute("utenteDTOAttribute",
				UtenteDTO.buildUtenteDTOInstance(utenteCaricato));
		request.setAttribute("ruoliUtenteDTOAttribute",utenteCaricato.getRuoli());
		RequestDispatcher rd = request.getRequestDispatcher("/admin/dettaglio.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
