package ttpsentregable5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.UsuarioRepository;
import ttpsentregable5.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRestController {
	@Autowired
	private UsuarioService userService;

	// Recupero todos los usuarios
//	@GetMapping
	public ResponseEntity<String> listAllUsers() {
		return new ResponseEntity<String>("hola", HttpStatus.OK);
	}

	@GetMapping
	public Usuario create() {
		// validaciones

		Usuario usu = new Usuario("Pepe00", "pepe@mail.com", "Pedro", "Chiappani", "1234", null, null, null, null);
		return userService.guardar(usu);
//	return usu;
	}
}
