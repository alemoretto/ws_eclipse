package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteInsertAbitanteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String nomeDaInserire = request.getParameter("nomeInput");
//		String cognomeDaInserire = request.getParameter("cognomeInput");
//		String codiceFiscaleDaInserire = request.getParameter("codiceFiscaleInput");
//		String etaDaInserire = request.getParameter("etaInput");
//		String mottoDiVitaDaInserire = request.getParameter("mottoDiVitaInput");
//		
//		Abitante abitanteNuovo = new Abitante(nomeDaInserire,cognomeDaInserire,codiceFiscaleDaInserire,Integer.parseInt(etaDaInserire),mottoDiVitaDaInserire);
//		
//		try {
////			request.setAttribute("inserisciAbitanteAttribute",
//					MyServiceFactory.getAbitanteServiceInstance().inserisciAbitante(abitanteNuovo);//);
//			request.setAttribute("listAbitantiAttributeName",
//					MyServiceFactory.getAbitanteServiceInstance().listaTuttiGliAbitanti());
//			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
//			rd.forward(request, response);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeDaInserire = request.getParameter("nomeInput");
		String cognomeDaInserire = request.getParameter("cognomeInput");
		String codiceFiscaleDaInserire = request.getParameter("codiceFiscaleInput");
		String etaDaInserire = request.getParameter("etaInput");
		String mottoDiVitaDaInserire = request.getParameter("mottoDiVitaInput");
		
		Abitante abitanteNuovo = new Abitante(nomeDaInserire,cognomeDaInserire,codiceFiscaleDaInserire,Integer.parseInt(etaDaInserire),mottoDiVitaDaInserire);
		
		try {
//			request.setAttribute("inserisciAbitanteAttribute",
					MyServiceFactory.getAbitanteServiceInstance().inserisciAbitante(abitanteNuovo);//);
			request.setAttribute("listAbitantiAttributeName",
					MyServiceFactory.getAbitanteServiceInstance().listaTuttiGliAbitanti());
			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
