package ttpsentregable5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.DTO.PreGrupoDTO;
import ttpsentregable5.model.Grupo;
import ttpsentregable5.service.GrupoService;

@RestController
@RequestMapping(value = "/grupos", produces=MediaType.APPLICATION_JSON_VALUE)
public class GrupoRestController {

	
	@Autowired
	private GrupoService grupoService;

	
	@PostMapping("/registrarUsuario")
	public ResponseEntity<String> crearGrupo(@RequestBody PreGrupoDTO grupoDTO) {
			
		try {
			
			//Validar campos completos
			if( grupoDTO.getCategoria() == null
					|| grupoDTO.getNombre() == null
					|| grupoDTO.getNombreUsuario() == null){
				
				return new ResponseEntity<>("Complete todos los campos", HttpStatus.BAD_REQUEST);
			}
			
			//Validacion
			//grupoService.validarCredencialesRegistrar();
				
			//Mapeo
			
			return new ResponseEntity<>("Grupo creado", HttpStatus.CREATED);
			
		} catch ( Exception e ) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	   
	}
}
