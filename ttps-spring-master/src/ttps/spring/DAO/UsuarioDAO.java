package ttps.spring.DAO;

import ttps.spring.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public Usuario recuperarPorNombreUsuario(String nom);
	public Usuario recuperarNomPass(String nom, String pass);

}
