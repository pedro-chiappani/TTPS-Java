

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class FiltroLogDeAccesos extends HttpFilter implements Filter {
       
   
	private static final long serialVersionUID = 1L;

	
    public FiltroLogDeAccesos() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String ip = httpRequest.getRemoteAddr();
		String host = httpRequest.getRemoteHost();
		String fecha = java.time.LocalDateTime.now().toString();
		String requestLine = httpRequest.getMethod() + " - " + httpRequest.getRequestURL() + " - " + httpRequest.getProtocol();
		String userAgent = httpRequest.getHeader("User-Agent");
		
		System.out.println("Ip del cliente: " + ip);
		System.out.println("Host del cliente: " + host);
		System.out.println("Fecha y hora: " + fecha);
		System.out.println("Request Line: " + requestLine);
		System.out.println("Request User-Agent: " + userAgent);
		
				
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
