package ttps.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import ttps.clasesDAOImplJdbc.FactoryDAO;
import ttps.clasesDeObjetosDelSistema.Mensaje;

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
		// TODO Auto-generated method stub
		List<Mensaje> mensajes = FactoryDAO.getMensaje().recuperarTodos();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.print("<h1>Mensajes</h1>");
		for (Mensaje men: mensajes) {
			out.print("<p>Mensaje:"+ men.getMensaje() + "</p>");
		}
		out.println("<a href='agregarMensajes.html'> Agregar Mensaje </a>");
		out.close();}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
