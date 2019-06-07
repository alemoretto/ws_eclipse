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

@WebServlet("/ExecuteEliminaAbitanteServlet")
public class ExecuteEliminaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private AbitanteService abitanteService;

//	@Autowired
//	private MunicipioService municipioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteEliminaAbitanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAbitanteDaPagina = request.getParameter("idAbitante");
		Abitante abitanteDaEliminare = abitanteService.caricaSingoloAbitante(Long.parseLong(idAbitanteDaPagina));
//		abitanteDaEliminare.setMunicipio(new Municipio());
//		abitanteService.aggiorna(abitanteDaEliminare);
		abitanteService.rimuovi(abitanteDaEliminare);

		request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitanti());
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
