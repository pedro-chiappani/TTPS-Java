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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.DTO.LoginDTO;
import ttpsentregable5.model.Token;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.service.UsuarioService;
import ttpsentregable5.service.TokenServices;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/usuarios", produces=MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TokenServices tokenServices;
	
	private final int EXPIRATION_IN_SEC = 100;
	
	@CrossOrigin("http://localhost:4200/") 
	@GetMapping("/listarUsuarios")
	public ResponseEntity<List<Usuario>> listAllUsers() {
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		if(usuarios.isEmpty()){
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}


	@CrossOrigin("http://localhost:4200/") 
	@PostMapping("/registrarUsuario")
	public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
			
		try {
			
			//Validar campos completos
			if( usuario.getNombreUsuario()==null 
					|| usuario.getClave()==null
					|| usuario.getEmail()==null
					|| usuario.getNombre()==null
					|| usuario.getApellido()==null){
				
				return new ResponseEntity<>("Complete todos los campos", HttpStatus.BAD_REQUEST);
			}
			
			
			usuarioService.validarCredencialesRegistrar(usuario.getNombreUsuario(), usuario.getClave(), usuario.getEmail());
				
			this.usuarioService.crear(usuario);
			return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
			
		} catch ( Exception e ) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	   
	}
	
	@CrossOrigin("http://localhost:4200/") 
	@PostMapping("/login")
	public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO loginDTO) {					
		
		
		if(isLoginSuccess(loginDTO.getNombreUsuario(), loginDTO.getClave())) {
            String token = tokenServices.generateToken(loginDTO.getNombreUsuario(), EXPIRATION_IN_SEC);
            
            return ResponseEntity.ok(new Token(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
		
		
		
	}

	private boolean isLoginSuccess(String username, String password) {
		return usuarioService.validarCredencialesLogin(username, password);
	}

}
