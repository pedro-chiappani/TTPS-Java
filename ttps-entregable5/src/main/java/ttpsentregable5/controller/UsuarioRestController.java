package ttpsentregable5.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.model.Usuario;
import ttpsentregable5.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios", produces=MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;

	
	
	
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
	
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUsuario(@RequestBody Map<String, String> request) {
		
		String nombreUsuario = request.get("nombreUsuario");
		String clave = request.get("clave");
		
		System.out.println(nombreUsuario + ' ' + clave);
		
		Map<String, String> response = new HashMap<>();
		
		if( usuarioService.validarCredencialesLogin(nombreUsuario, clave) ) {

			response.put("mensaje", "Inicio de sesion Exitoso");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("mensaje", "Credenciales Incorrectas");
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}
		
		
	}


}
