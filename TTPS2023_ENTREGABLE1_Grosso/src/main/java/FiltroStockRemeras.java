

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroStockRemeras
 */
public class FiltroStockRemeras extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroStockRemeras() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Obtener el contexto de la aplicación
        ServletContext servletContext = request.getServletContext();
        
        // Recuperar el valor del atributo "contadorRemeras"
        Integer contadorRemeras = (Integer) servletContext.getAttribute("contadorRemeras");
        
        
        if (contadorRemeras != null && contadorRemeras > 0) {
            //System.out.print("Contador: " + contadorRemeras);
            contadorRemeras--;
            servletContext.setAttribute("contadorRemeras", contadorRemeras);
            chain.doFilter(request, response);
            
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/TTPS2023_ENTREGABLE1_Grosso/PaginaAgotada.html"); 
        }
	}

	

}
