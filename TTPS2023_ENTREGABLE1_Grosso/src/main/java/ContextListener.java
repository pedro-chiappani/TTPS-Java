

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
public class ContextListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        String cantRemeras 	= servletContext.getInitParameter("cantidadRemeras");
        
        servletContext.setAttribute("contadorRemeras", Integer.valueOf(cantRemeras));
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        
    }
	
}
