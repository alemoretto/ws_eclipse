package it.prova.gestionecartelleesattorialispringjpa.web.servlet.cartellaesattoriale;

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

import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;
import it.prova.gestionecartelleesattorialispringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;
import it.prova.gestionecartelleesattorialispringjpa.utility.Utility;

@WebServlet("/ExecuteModificaCartellaEsattorialeServlet")
public class ExecuteModificaCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Autowired
	private ContribuenteService contribuenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaCartellaEsattorialeServlet() {
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

		if (Utility.inputCartellaEsattoriale(request).isNotValid()) {
			request.setAttribute("messaggioDiErrore", Utility.inputCartellaEsattoriale(request).getMessaggio());
			Long idCartellaEsattorialeDaPagina = Long.parseLong(request.getParameter("idCartellaEsattoriale"));
			request.setAttribute("cartellaEsattorialeDaModificareAttributeName",
					cartellaEsattorialeService.caricaEager(idCartellaEsattorialeDaPagina));
			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAll());
			RequestDispatcher rd = request.getRequestDispatcher("/cartellaesattoriale/modifica.jsp");
			rd.forward(request, response);
			return;
		}

		Long idInput = Long.parseLong(request.getParameter("idInput"));
		String denominazioneInput = request.getParameter("denominazioneInput");
		String descrizioneInput = request.getParameter("descrizioneInput");
		int importoInput = Integer.parseInt(request.getParameter("importoInput"));
		Contribuente contribuenteInput = new Contribuente(Long.parseLong(request.getParameter("contribuenteInput")));

		CartellaEsattoriale cartellaEsattorialeDaModificare = new CartellaEsattoriale(idInput, denominazioneInput,
				descrizioneInput, importoInput, contribuenteInput);

		cartellaEsattorialeService.aggiorna(cartellaEsattorialeDaModificare);

		response.sendRedirect("SendRedirectCartellaEsattorialeServlet");
	}

}
