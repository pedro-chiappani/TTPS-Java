package ttpsentregable5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttpsentregable5.model.Grupo;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.service.GrupoService;

@RestController
@RequestMapping(value = "/grupos", produces= MediaType.APPLICATION_JSON_VALUE)
public class GrupoRestController {
	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping
	public ResponseEntity<List<Grupo>> listAllGrupos() {
		List<Grupo> grupos = grupoService.listarGrupos();
		if (grupos.isEmpty()) {
			return new ResponseEntity<List<Grupo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Grupo>>(grupos, HttpStatus.OK);
	}

}
