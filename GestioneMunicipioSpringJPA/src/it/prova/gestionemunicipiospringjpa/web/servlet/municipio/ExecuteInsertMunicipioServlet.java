package it.prova.gestionemunicipiospringjpa.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

@WebServlet("/ExecuteInsertMunicipioServlet")
public class ExecuteInsertMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    public ExecuteInsertMunicipioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("sssssssssssssssssss at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestinazione = "/municipio/result.jsp";

//		if (!Utility.checkInputVino(request).getEsito()) {
//			request.setAttribute("messaggioDiErrore", Utility.checkInputVino(request).getMessaggio());
//			
//			paginaDestinazione = "nuovoVino.jsp";
//		} else {
			String descrizioneInput = request.getParameter("descrizioneInput");
			String codiceInput = request.getParameter("codiceInput");
			String ubicazioneInput = request.getParameter("ubicazioneInput");
			
			Municipio municipioDaInserire = new Municipio(descrizioneInput, codiceInput, ubicazioneInput);
			municipioService.inserisciNuovo(municipioDaInserire);

			request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());
//		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	}

}
