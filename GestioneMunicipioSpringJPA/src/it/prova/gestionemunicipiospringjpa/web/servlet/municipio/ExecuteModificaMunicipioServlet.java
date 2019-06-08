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
import it.prova.gestionemunicipiospringjpa.utility.Utility;

@WebServlet("/ExecuteModificaMunicipioServlet")
public class ExecuteModificaMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteModificaMunicipioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		String paginaDestinazione = "/municipio/result.jsp";

		if (!Utility.checkInputMunicipio(request).getEsito()) {
			request.setAttribute("messaggioDiErrore", Utility.checkInputMunicipio(request).getMessaggio());
			request.setAttribute("municipioDaModificareAttributeName",municipioService.caricaSingoloMunicipio(Long.parseLong(request.getParameter("idInput"))));
			paginaDestinazione = "/municipio/modifica.jsp";
		} else {
			String descrizioneInput = request.getParameter("descrizioneInput");
			String codiceInput = request.getParameter("codiceInput");
			String ubicazioneInput = request.getParameter("ubicazioneInput");
			Long idVinoDaPagina = Long.parseLong(request.getParameter("idInput"));
			
			Municipio municipioDaModificare = new Municipio(idVinoDaPagina,descrizioneInput, codiceInput, ubicazioneInput);
			municipioService.aggiorna(municipioDaModificare);

			request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(paginaDestinazione);
		rd.forward(request, response);
	
	}

}
