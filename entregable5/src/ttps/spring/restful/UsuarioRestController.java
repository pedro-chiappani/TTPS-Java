package ttps.spring.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Usuario;
import ttps.spring.service.UsuarioService;

@RestController
@RequestMapping(value="/")

public class UsuarioRestController {


	//Recupero todos los usuarios
	@GetMapping
	public ResponseEntity<String> listAllUsers() {
		return new ResponseEntity<String>("hola", HttpStatus.OK);
	}
}