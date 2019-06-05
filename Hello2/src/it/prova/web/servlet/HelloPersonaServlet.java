package it.prova.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Persona;

@WebServlet("/HelloPersonaServlet")
public class HelloPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloPersonaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Persona persona = new Persona(request.getParameter("nomeInput"), request.getParameter("cognomeInput"));
//		String parametroNomeInput = request.getParameter("nomeInput");
		
		
		request.setAttribute("persona_attribute", persona);
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
