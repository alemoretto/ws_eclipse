package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

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

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;
import it.prova.gestionemunicipiospringjpa.utility.Utility;

@WebServlet("/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private AbitanteService abitanteService;
	
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteModificaAbitanteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestinazione = "/abitante/result.jsp";

		if (!Utility.checkInputAbitante(request).getEsito()) {
			request.setAttribute("messaggioDiErrore", Utility.checkInputAbitante(request).getMessaggio());
			request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());
			paginaDestinazione = "/abitante/insert.jsp";
		} else {
			String nomeInput = request.getParameter("nomeInput");
			String cognomeInput = request.getParameter("cognomeInput");
			String residenzaInput = request.getParameter("residenzaInput");
			int etaInput = Integer.parseInt(request.getParameter("etaInput"));
			Long idInput = Long.parseLong(request.getParameter("idInput"));
			Municipio municipioInput = new Municipio(Long.parseLong(request.getParameter("municipioInput"))); 
					
			Abitante abitanteDaInserire = new Abitante(idInput, nomeInput, cognomeInput, etaInput, residenzaInput, municipioInput);
			abitanteService.aggiorna(abitanteDaInserire);

			request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitanti());
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	}
	}

