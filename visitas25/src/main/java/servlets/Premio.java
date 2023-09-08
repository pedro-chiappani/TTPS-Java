package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Premio
 */

public class Premio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int visita =0;
	private String mensaje;
    /** 
     * Default constructor. 
     */

    public Premio() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		mensaje = this.getServletConfig().getInitParameter("mensaje");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		visita = visita + 1;
		response.setContentType("text/html");
		String nom = request.getParameter("nombre");
		PrintWriter out = response.getWriter();
		
		int aux = mensaje.indexOf("@");
		int aux2 = mensaje.indexOf("#");
		String mensaje1 = mensaje.substring(1,aux) + nom + mensaje.substring(aux+1, aux2) + visita + mensaje.substring(aux2+1,mensaje.length()); 
		String mensaje2 = mensaje.replace("@", nom);
		mensaje2 = mensaje2.replace("#", String.valueOf(visita));
		out.println("<h1>" + mensaje2 + "</h1>");
		
	}

}
