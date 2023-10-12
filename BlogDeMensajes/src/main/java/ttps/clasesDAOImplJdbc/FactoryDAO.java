package ttps.clasesDAOImplJdbc;

import ttps.clasesDAO.*;

public class FactoryDAO {
	
	public static UsuarioDAO getUsuario() {
		return new UsuarioDAOjdbc();
	}
	
	public static MensajeDAO getMensaje() {
		return new MensajeDAOjdbc();
	}

}
