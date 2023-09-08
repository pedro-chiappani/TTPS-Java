package ttps.clasificados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet(
		name="Login",
		urlPatterns={"/ServletLogin"}
)
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
   
    public Login() {
        
    	this.usuarios.add( new Usuario("joaquin","123456","Administrador") );
    	this.usuarios.add( new Usuario("pedro","123456","Publicador") );
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		Usuario usu;
		
		String nombreUsuario = request.getParameter("usuario");
		String contraseña = request.getParameter("clave");
		
		usu = usuarios.stream()
                .filter(usuario -> usuario.getNombre().equals(nombreUsuario) & usuario.getPassword().equals(contraseña))
                .findFirst()
                .orElse(null);
		
		if(usu == null) {
			response.sendRedirect(request.getContextPath() + "/error.html");
		} else if (usu.getPerfil()=="Publicador") {
			response.sendRedirect(request.getContextPath() + "/publicador.html");
		} else if(usu.getPerfil()=="Administrador") {
			response.sendRedirect(request.getContextPath() + "/administrador.html");
		}else {
			response.sendRedirect(request.getContextPath() + "/error.html");
		}
	}

}
