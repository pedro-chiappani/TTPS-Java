package ttps.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@Component
public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	@Autowired
	public UsuarioService(UsuarioDAO usu) {
		this.usuarioDAO = usu;
	}

	public Usuario recuperarPorNombre(String nom) {
		return this.usuarioDAO.recuperarPorNombreUsuario(nom);
	}

	public List<Usuario> recuperarTodos() {
		return this.usuarioDAO.recuperarTodos();

	}

}
