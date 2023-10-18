package ttps.clasesDAO;

import ttps.clasesDAOImplJPA.MensajeDAOJPA;
import ttps.clasesDAOImplJPA.UsuarioDAOJPA;
import ttps.clasesDAOImplJdbc.MensajeDAOJdbc;
import ttps.clasesDAOImplJdbc.UsuarioDAOJdbc;

public class FactoryDAO {
	
	public static UsuarioDAO getUsuario() {
		String daoImpl="JPA";
		
		if( daoImpl.equals("JPA") ){
			return new UsuarioDAOJPA();
		}else {		
			return new UsuarioDAOJdbc();
		}
	}
	
	public static MensajeDAO getMensaje() {
		String daoImpl="JPA";
		
		if( daoImpl.equals("JPA") ){
			return new MensajeDAOJPA();
		}else {		
			return new MensajeDAOJdbc();
		}
	}

}