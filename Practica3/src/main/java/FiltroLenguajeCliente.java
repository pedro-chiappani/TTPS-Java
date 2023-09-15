

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroLenguajeCliente
 */
public class FiltroLenguajeCliente extends HttpFilter implements Filter {
       
    
    public FiltroLenguajeCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

		
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String acceptLanguage = httpRequest.getHeader("Accept-Language");
		String archivoProperties;
		
		//seteo lenguaje de app
		if (acceptLanguage == null || acceptLanguage.isEmpty()) {
			
			// Valor predeterminado en caso de que no se especifique un lenguaje
		    acceptLanguage = "en";
		}else {			
			int indice = acceptLanguage.indexOf("-");
			acceptLanguage = acceptLanguage.substring(0,indice);			
		}
		
		//seteo nombre de atributo
		if (acceptLanguage.equals("es")) {
			archivoProperties = "textos_es.properties";
		}else {
			archivoProperties = "textos_en.properties";
		}		
		
		System.out.print(acceptLanguage + " " + archivoProperties);
		request.setAttribute("archivoProperties", archivoProperties);
		
		
		//System.out.println("Lenguaje preferido del navegador: " + acceptLanguage);
		
		chain.doFilter(request, response);
	}

	

}
