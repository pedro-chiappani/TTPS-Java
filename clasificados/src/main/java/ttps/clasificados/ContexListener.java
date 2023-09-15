package ttps.clasificados;

import java.beans.beancontext.BeanContextProxy;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContexListener
 *
 */
@WebListener
public class ContexListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContexListener() {
        // TODO Auto-generated constructor stub
    }
    
    public void contextInitialized(ServletContextEvent sce) {
    	String nom = sce.getServletContext().getInitParameter("nombre");
    	String mail = sce.getServletContext().getInitParameter("email");
    	String tel = sce.getServletContext().getInitParameter("telefono");
    	
//    	SitioClasificado sitio = new SitioClasificado(nom, mail, tel);
    	
    	ServletContext contexto = sce.getServletContext();
    	
    	contexto.setAttribute("sitio", new SitioClasificado(nom,mail,tel));
    }
}
