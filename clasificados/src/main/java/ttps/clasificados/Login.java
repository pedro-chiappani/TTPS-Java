package ttps.clasificados;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    	usuarios.add(new Usuario("Pedro", "123456", "Publicador"));
		usuarios.add(new Usuario("Joaquin", "123456", "Administrador"));
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
		response.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menu");
		
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("password");
		
		Usuario usu = usuarios.stream()
				.filter(u -> u.getNombre().equals(nombre) & u.getPassword().equals(pass))
				.findFirst()
				.orElse(null);
		if (dispatcher != null) {
			if (usu == null)
				request.setAttribute("err", "Error");
			else 
				request.setAttribute("usu", new Usuario(usu));
			dispatcher.forward(request, response);
		}
		else {
			System.out.print("bobo");
		}
	}

}
