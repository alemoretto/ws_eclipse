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
import it.prova.gestionecartelleesattorialispringjpa.model.dto.CartellaEsattorialeDTO;
import it.prova.gestionecartelleesattorialispringjpa.service.cartellaesattoriale.CartellaEsattorialeService;
import it.prova.gestionecartelleesattorialispringjpa.service.contribuente.ContribuenteService;

@WebServlet("/ExecuteInserisciCartellaEsattorialeServlet")
public class ExecuteInserisciCartellaEsattorialeServlet extends HttpServlet {
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

	public ExecuteInserisciCartellaEsattorialeServlet() {
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

		CartellaEsattorialeDTO cartellaEsattorialeDTO = new CartellaEsattorialeDTO(request.getParameter("denominazioneInput"),
				request.getParameter("descrizioneInput"), request.getParameter("importoInput"),
				request.getParameter("contribuenteInput"));
		
		if (!cartellaEsattorialeDTO.validate().isEmpty()) {
			request.setAttribute("cartellaEsattorialeDTOAttribute", cartellaEsattorialeDTO);
			request.setAttribute("messaggiDiErrore", cartellaEsattorialeDTO.validate());
			request.setAttribute("listaContribuentiAttributeName", contribuenteService.listAll());;
			RequestDispatcher rd = request.getRequestDispatcher("/cartellaesattoriale/insert.jsp");
			rd.forward(request, response);

			return;
		}
		CartellaEsattoriale cartellaEsattorialeDaInserire = CartellaEsattorialeDTO.buildCartellaEsattorialeInstance(cartellaEsattorialeDTO);
		cartellaEsattorialeDaInserire.setContribuente(new Contribuente(Long.parseLong(request.getParameter("contribuenteInput"))));
		cartellaEsattorialeService.inserisci(cartellaEsattorialeDaInserire);

		response.sendRedirect("SendRedirectCartellaEsattorialeServlet");

	}

}
