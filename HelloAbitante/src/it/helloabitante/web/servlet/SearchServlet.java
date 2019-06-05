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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinazione = null;

		String nomeDaPagina = request.getParameter("nomeInput");
		String cognomeDaPagina = request.getParameter("cognomeInput");
		Abitante abitanteExample = new Abitante(nomeDaPagina,cognomeDaPagina);

			try {
				request.setAttribute("listAbitantiAttributeName",
						MyServiceFactory.getAbitanteServiceInstance().findByExample(abitanteExample));
			} catch (Exception e) {
				e.printStackTrace();
			}

		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
	}

}
