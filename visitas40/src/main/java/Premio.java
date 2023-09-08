import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebInitParam;

/**
 * Servlet implementation class Premio
 */
@WebServlet(
	    name = "ServletPremio",
	    urlPatterns = {"/ServletPremio"},
	    initParams = {
	        @WebInitParam(name="mensaje", value="¡Felicitaciones @! eres el visitante número # de nuestro sitio y has sido\r\n"
	        				+ "seleccionado para el gran premio TTPS - Cursada APROBADA\r\n")
	    }
	)
public class Premio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int cant=0;
	private String saludo;
	public void init(){
		saludo = this.getServletConfig().getInitParameter("mensaje");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		cant++;
		
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		
		
		
		out.println("<html><body>");
		out.println("<h1> " + saludo.replace("@", nombre).replace("#", String.valueOf(cant)) + " </h1>");
		out.println("</body></html>");
		
		out.close();		
		//doGet(request, response);
	}

}
