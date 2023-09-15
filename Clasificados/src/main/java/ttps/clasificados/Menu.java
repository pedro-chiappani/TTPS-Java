package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet(
		name="Menu",
		urlPatterns={"/Menu"}
)
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String itemMenu = (String) request.getAttribute("menu");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Encabezado");
		
		
		//System.out.println(itemMenu);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head>");
		
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>" + itemMenu + "</title>");
		
		out.println("</head>");
		out.println("<html><body>");

		if (dispatcher != null) {
			dispatcher.include(request, response); 
		}
		
		out.println("<h1><p>" + itemMenu + "</p></h1>");
		
		if(itemMenu == "Error") {
			out.println("<a href=\"/Clasificados/login.html\"> Login </a>");
		}
		
		out.println("</body></html>");
		
		out.close();
		
		// Respuesta Practica 2 - ejercicio 3b
		
		// con sendRedirect no puedo enviar informacion al servlet que recibe el manejo
		// con sendRedirect estamos enviando una nueva request
		// en cambio con forward enviamos la misma request y response con la que estabamos trabajando
		
				
	}

	

}
