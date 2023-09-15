package ttps.clasificados;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Encabezado")
public class Encabezado extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Encabezado() {
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
        ServletContext servletContext = getServletContext();
        SitioClasificado sitioClasificado = (SitioClasificado) servletContext.getAttribute("sitioClasificado");

        response.getWriter().println("<h1>Información del Sitio Web</h1>");
        response.getWriter().println("<p>Nombre del Sitio: " + sitioClasificado.getNombre() + "</p>");
        response.getWriter().println("<p>Email: " + sitioClasificado.getEmail() + "</p>");
        response.getWriter().println("<p>Telefono: " + sitioClasificado.getTelefono() + "</p>");

		
	}
    
	
	

}
