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

import it.prova.gestionecartelleesattorialispringjpa.service.cartellaesattoriale.CartellaEsattorialeService;

@WebServlet("/VisualizzaDettaglioCartellaEsattorialeServlet")
public class VisualizzaDettaglioCartellaEsattorialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private CartellaEsattorialeService cartellaEsattorialeService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public VisualizzaDettaglioCartellaEsattorialeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		String idCartellaEsattorialeDaPagina = request.getParameter("idCartellaEsattoriale");

		request.setAttribute("cartellaEsattorialeAttributeName",
				cartellaEsattorialeService.caricaEager(Long.parseLong(idCartellaEsattorialeDaPagina)));
		RequestDispatcher rd = request.getRequestDispatcher("/cartellaesattoriale/dettaglio.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
