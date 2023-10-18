package ttps.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ttps.clasesDAO.FactoryDAO;
import ttps.clasesDeObjetosDelSistema.Mensaje;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class VisualizarMensajes
 */
public class VisualizarMensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarMensajes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		List<Mensaje> mensajes = FactoryDAO.getMensaje().recuperarTodos();		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head>");
		
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title> Visualizar Mensaje </title>");
		
		out.println("</head>");
		out.println("<html><body>");
		
		out.println("<a href='agregarMensaje.html'> Agregar Mensaje </a>");
		
		out.println("<p> Mensajes: </p>");
		
		out.println("<ul>");
		
		for (Mensaje msj: mensajes) {
			out.println("<li>" + msj.toString() + "</li>");
		}
		
		out.println("</ul>");
		
		out.println("</body></html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
