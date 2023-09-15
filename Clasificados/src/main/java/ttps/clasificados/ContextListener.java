package ttps.clasificados;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {

    
	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        
        String nombreSitio 	= servletContext.getInitParameter("nombreSitio");
        String email 	 	= servletContext.getInitParameter("email");
        String telefono 	= servletContext.getInitParameter("telefono");

        
        SitioClasificado sitioClasificado = new SitioClasificado(nombreSitio, email, telefono);

        
        servletContext.setAttribute("sitioClasificado", sitioClasificado);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        
    }
	
}
