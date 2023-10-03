package ttps.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GuardarMensaje
 */
public class GuardarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarMensaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head>");
		
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title> Visualizar Mensaje </title>");
		
		out.println("</head>");
		out.println("<html><body>");
		
		out.println("GUARDAR MENSAJE GET");
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head>");
		
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title> Visualizar Mensaje </title>");
		
		out.println("</head>");
		out.println("<html><body>");
		
		out.println("GUARDAR MENSAJE POST");
		
		out.println("</body></html>");
	}

}
