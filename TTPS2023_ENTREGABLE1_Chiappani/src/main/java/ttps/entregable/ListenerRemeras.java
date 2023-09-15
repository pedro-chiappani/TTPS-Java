package ttps.entregable;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerRemeras
 *
 */
@WebListener
public class ListenerRemeras implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerRemeras() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	String cant = sce.getServletContext().getInitParameter("camisetas");
    	ServletContext contexto = sce.getServletContext();
    	contexto.setAttribute("cantidad", Integer.valueOf(cant));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
