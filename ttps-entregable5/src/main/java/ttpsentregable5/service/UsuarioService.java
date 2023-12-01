package ttpsentregable5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
	public Usuario crear(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario obtenerPorId(Long id) throws Exception {
		Optional<Usuario> usu = usuarioRepository.findById(id);
		if (!usu.isPresent()) {
			throw new Exception("No se encontro el usuario");
		}	
		return usu.get();
	}
	
	public boolean validarCredencialesLogin(String nombreUsuario, String clave) {
		
		Usuario usu = usuarioRepository.recuperarPorNombreUsuario(nombreUsuario);
		
		if( usu == null ) {
			return false;
		}
		
		return usu.getClave().equals(clave);
	}
	
	public void validarCredencialesRegistrar(String nombreUsuario, String contraseña, String email) throws Exception {
		
		if( contraseña.length() < 8) {
			throw new Exception("Contraseña muy corta");
		}
		
		if( usuarioRepository.recuperarPorEmail(email)!=null) {
			throw new Exception("Email existente");
		}
		
		if( usuarioRepository.recuperarPorNombreUsuario(nombreUsuario)!=null ) {
			throw new Exception("Nombre usuario existente");
		}
		
	}
	
}