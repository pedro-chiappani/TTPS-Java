package ttps.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ttps.clasesDAO.MensajeDAO;
import ttps.clasesDAOImplJdbc.MensajeDAOJdbc;
import ttps.clasesDeObjetosDelSistema.Mensaje;

import java.io.IOException;
import java.io.PrintWriter;

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
				
		MensajeDAOJdbc mDAO = new MensajeDAOJdbc(); 
		Mensaje mensaje1 = mDAO.recuperar((long) 1);
		
		System.out.print(mensaje1.toString());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head>");
		
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title> Visualizar Mensaje </title>");
		
		out.println("</head>");
		out.println("<html><body>");

		out.println("<p>");
		
		out.println("Mensajes: ");
		
		
		
		out.println("</p>");
		
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
