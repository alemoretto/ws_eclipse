package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MottoDelGiornoServlet")
public class MottoDelGiornoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MottoDelGiornoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("ciao").append(request.getContextPath());
		
		String parametroMottoDelGiornoInput = request.getParameter("mottoDelGiornoInput");
		
		request.setAttribute("mottoDelGiorno_attribute", parametroMottoDelGiornoInput);
		
		RequestDispatcher rd = request.getRequestDispatcher("mottoDelGiorno.jsp");
		rd.forward(request, response);
	}

}
