package ttpsentregable5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	private UsuarioRepository userRepository;

	public Usuario guardar(Usuario user) {
// validaciones
		return userRepository.save(user);
	}
}
