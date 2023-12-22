package ttpsentregable5.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.model.Usuario;
import ttpsentregable5.DTO.LoginDTO;
import ttpsentregable5.model.Credentials;
import ttpsentregable5.repository.UsuarioRepository;
import ttpsentregable5.service.TokenServices;
import ttpsentregable5.service.UsuarioService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/usuarios", produces= MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TokenServices tokenServices;
	
	private final int EXPIRATION_IN_SEC = 100;

	
	@GetMapping("/listarUsuarios")
	public ResponseEntity<List<Usuario>> listAllUsers() {
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		if(usuarios.isEmpty()){
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		}

	@PostMapping("/registrarUsuario")
	public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
			
		try {
			
			if (usuario.getNombreUsuario()==""
					|| usuario.getClave()==""
					|| usuario.getEmail()==""
					|| usuario.getNombre()==""
					|| usuario.getApellido()==""
					)
				
				return new ResponseEntity<>("Complete todos los campos", HttpStatus.BAD_REQUEST);
			
			usuarioService.validarCredencialesRegistrar(usuario.getNombreUsuario(), usuario.getClave(), usuario.getEmail());
				
			this.usuarioService.crear(usuario);
			return new ResponseEntity<>(HttpStatus.CREATED);
			
		} catch ( Exception e ) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	   
	}
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginDTO userpass) {

        if(isLoginSuccess(userpass.getNombreUsuario(), userpass.getClave())) {
            String token = tokenServices.generateToken(userpass.getNombreUsuario(), EXPIRATION_IN_SEC);
            return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, userpass.getNombreUsuario()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        // recupero el usuario de la base de usuarios
        return usuarioService.validarCredencialesLogin(username, password);
    }


}