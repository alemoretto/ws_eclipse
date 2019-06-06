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

import it.prova.model.Vino;
import it.prova.service.VinoService;
import it.prova.utility.Utility;

@WebServlet("/ExecuteModificaVinoServlet")
public class ExecuteModificaVinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private VinoService vinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    public ExecuteModificaVinoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paginaDestinazione = "result.jsp";

		if (!Utility.checkInputVino(request).getEsito()) {
			request.setAttribute("messaggioDiErrore", Utility.checkInputVino(request).getMessaggio());
			request.setAttribute("vinoDaModificareAttributeName",vinoService.caricaSingoloVino(Long.parseLong(request.getParameter("idInput"))));
			paginaDestinazione = "modifica.jsp";
		} else {
			String nomeInput = request.getParameter("nomeInput");
			String uvaInput = request.getParameter("uvaInput");
			String cantinaInput = request.getParameter("cantinaInput");
			Integer annataInput = Integer.parseInt(request.getParameter("annataInput"));
			String localitaInput = request.getParameter("localitaInput");
			Long idVinoDaPagina = Long.parseLong(request.getParameter("idInput"));
			
			Vino vinoDaAggiornare = new Vino(idVinoDaPagina,nomeInput, uvaInput, cantinaInput, localitaInput, annataInput);
			vinoService.aggiornaVino(vinoDaAggiornare);

			request.setAttribute("listaViniAttributeName", vinoService.listaCompleta());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	}

}
