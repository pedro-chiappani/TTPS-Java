

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Servlet implementation class LoginMultilenguaje
 */
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginMultilenguaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtener el nombre del archivo .properties del atributo establecido por el filtro
        String archivoProperties = (String) request.getAttribute("archivoProperties");
        
        System.out.print("llega tipo:" + archivoProperties);
        
        // Si el atributo no se estableció (lenguaje por defecto)
        if (archivoProperties == null) {
            archivoProperties = "textos_en.properties"; // Lenguaje por defecto (inglés)
        }
        
        ResourceBundle bundle = ResourceBundle.getBundle(archivoProperties);
        String titulo = bundle.getString("titulo");
        String labelusuario = bundle.getString("labelusuario");
        String labelpassword = bundle.getString("labelpassword");
        

       
        // Genera la página HTML con los textos
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>" + titulo + "</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>" + titulo + "</h1>");
        response.getWriter().println("<form action='/tu-aplicacion/procesar-login' method='post'>");
        response.getWriter().println("<label for='usuario'>" + labelusuario + "</label>");
        response.getWriter().println("<input type='text' id='usuario' name='usuario'><br>");
        response.getWriter().println("<label for='clave'>" + labelpassword + "</label>");
        response.getWriter().println("<input type='password' id='clave' name='clave'><br>");
        response.getWriter().println("<input type='submit' value='Iniciar Sesión'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
