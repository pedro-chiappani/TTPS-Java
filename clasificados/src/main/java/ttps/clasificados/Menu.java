package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Menu() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usu = (Usuario) request.getAttribute("usu");	

		String err = (String) request.getAttribute("Error");
		PrintWriter out = response.getWriter();
		if (usu == null) {
			out.print("<h1>Error en el usuario</h1>\n"
					+ "	<a href=\"/clasificados/login.html\">Home</a>");
		}
		else {
			out.print("<html>\n"
					+ "<head>");
			out.print(
					 "<title>Insert title here</title>\n"
					+ "</head>");
			out.print("<body>\n"
						+ "	<h1>Felicitaciones "+ usu.getPerfil() +"</h1>\n"
						+ "	<ul>\n"
						+ "");
			if (usu.getPerfil().equals("Administrador")) {
				out.print("<li><a href=\"#\">Listar Usuarios Publicadores</a></li>\n"
						+ "		<li><a href=\"#\">ABM Administradores</a></li>\n"
						+ "		<li><a href=\"#\">Ver Estadísticas</a></li>");
			}
			else {
				out.print("<li><a href=\"#\">Actualizar Datos de Contacto</a></li>\n"
						+ "		<li><a href=\"#\">ABM De Publicaciones</a></li>\n"
						+ "		<li><a href=\"#\">Contestar Consulta</a></li>");
			}
			out.print("</ul>\n"
					+ "<a href=\"/clasificados/login.html\">Home</a>\n"
					+ "</body>\n"
					+ "</html>");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
