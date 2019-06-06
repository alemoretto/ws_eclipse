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

import it.prova.service.VinoService;

@WebServlet("/PreparaEliminaVinoServlet")
public class PreparaEliminaVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private VinoService vinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PreparaEliminaVinoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idVinoDaPagina = request.getParameter("idVino");

		request.setAttribute("vinoSingoloAttributeName",
				vinoService.caricaSingoloVino(Long.parseLong(idVinoDaPagina)));

		RequestDispatcher rd = request.getRequestDispatcher("confermaRimozione.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
